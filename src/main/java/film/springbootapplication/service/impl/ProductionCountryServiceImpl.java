package film.springbootapplication.service.impl;

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

//    @Override
//    public ProductionCountry updateProductionById(Long id) {
//        return productionCountryRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException(String.format("ProductionCountry with ID [%d] not found", id)));
//    }

    @Autowired
    private ProductionCountryRepository productionCountryRepository;

    @Override
    public List<ProductionCountry> getAll() {
        return productionCountryRepository.findAll();
    }

    @Override
    public Optional<ProductionCountry> getById(Long id) {
        return productionCountryRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        productionCountryRepository.deleteById(id);
    }

    @Override
    public ProductionCountry create(ProductionCountry movie) {
        return productionCountryRepository.saveAndFlush(movie);
    }

    @Override
    public ProductionCountry update(ProductionCountry movie) {
        return null;
    }
}
