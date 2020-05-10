package film.springbootapplication.repository;

import film.springbootapplication.model.ProductionCompany;

import java.util.Optional;

public interface ProductionCountryRepository extends BaseRepository<ProductionCompany> {

    ProductionCompany findByIdAndActive(Long id, boolean active);

    Optional<ProductionCompany> findByName(String name);

}
