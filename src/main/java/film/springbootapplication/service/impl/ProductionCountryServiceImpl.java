package film.springbootapplication.service.impl;

import film.springbootapplication.model.Movie;
import film.springbootapplication.model.ProductionCountry;
import film.springbootapplication.repository.ProductionCountryRepository;
import film.springbootapplication.service.ProductionCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductionCountryServiceImpl implements ProductionCountryService {

    @Autowired
    private ProductionCountryRepository productionCountryRepository;

    @Override
    public List<ProductionCountry> getAllProductionCountry() {
        return productionCountryRepository.findAll();
    }

    @Override
    public Optional<ProductionCountry> getProductionCountryById(Long id) {
        return productionCountryRepository.findById(id);
    }

    @Override
    public void deleteProductionCountry(Long id) {
        productionCountryRepository.deleteById(id);
    }

    @Override
    public ProductionCountry createProductionCountry(ProductionCountry productionCountry) {
        return productionCountryRepository.save(productionCountry);
    }

    @Override
    public ProductionCountry updateProductionCountry(ProductionCountry productionCountry) {
        return productionCountryRepository.save(productionCountry);
    }

    @Override
    public ProductionCountry updateProductionById(Long id) {
        return productionCountryRepository.findByIdAndUpdated(id);
    }

}
