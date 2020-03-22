package film.springbootapplication.repository;

import film.springbootapplication.model.ProductionCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionCountryRepository extends JpaRepository<ProductionCountry, Long> {
}
