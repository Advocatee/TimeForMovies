package film.springbootapplication.configuration;

import film.springbootapplication.mapper.CustomModelMapper;
import film.springbootapplication.mapper.service.ModelMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {


    @Bean
    public CustomModelMapper modelMapper(@Autowired ModelMapperFactory modelMapperFactory) {
        return modelMapperFactory.createMapper();
    }
}
