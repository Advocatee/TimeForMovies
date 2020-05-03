package film.springbootapplication.repository;

import film.springbootapplication.model.ProductionCompany;

public interface ProductionCountryRepository extends BaseRepository<ProductionCompany> {

    ProductionCompany findByIdAndActive(Long id, boolean active);

}
