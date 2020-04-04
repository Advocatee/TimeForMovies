package film.springbootapplication.repository;

import film.springbootapplication.model.ProductionCountry;

public interface ProductionCountryRepository extends BaseRepository<ProductionCountry> {

    ProductionCountry findByIdAndUpdated(Long id);
}
