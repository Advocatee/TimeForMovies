package film.springbootapplication.configuration;

import film.springbootapplication.service.impl.MyUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("roma").password("$2y$12$4J2kgGpX/BQRPdifsZmJHu8ZJqjvmMEOxNcCsph5NoTcLeesAtxP6").roles("ADMIN")
                .and()
                .withUser("user").password("$2y$12$p5ILZBQZz2QrJLFL6luA0OCGLodNN/IwOIoKyJy5Sqxl1M6GjwC8.").roles("USER");
//        auth.authenticationProvider(authenticationProvider());

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/genres**").hasRole("ADMIN")
                .antMatchers("/movies**").authenticated()
                .antMatchers("/companies**").hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                .and()
                .logout().logoutSuccessUrl("/");
    }
}
