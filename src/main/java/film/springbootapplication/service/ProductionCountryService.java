package film.springbootapplication.service;

import film.springbootapplication.model.ProductionCountry;

import java.util.List;
import java.util.Optional;

public interface ProductionCountryService {

    List<ProductionCountry> getAllProductionCountry();

    Optional<ProductionCountry> getProductionCountryById(Long id);

    void deleteProductionCountry(Long id);

    ProductionCountry createProductionCountry(ProductionCountry productionCountry);

    ProductionCountry updateProductionCountry(ProductionCountry productionCountry);

    ProductionCountry updateProductionById(Long id);

}
