package film.springbootapplication.repository;

import film.springbootapplication.model.BaseEntity;
import film.springbootapplication.model.ProductionCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

}
