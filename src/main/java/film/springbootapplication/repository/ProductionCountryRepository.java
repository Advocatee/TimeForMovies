package film.springbootapplication.repository;

import film.springbootapplication.model.ProductionCompany;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductionCountryRepository extends BaseRepository<ProductionCompany> {

    ProductionCompany findByIdAndActive(Long id, boolean active);

    Optional<ProductionCompany> findByName(String name);

    @Query("from ProductionCompany as pc where pc.active = true ")
    List<ProductionCompany> findByActive();

}
