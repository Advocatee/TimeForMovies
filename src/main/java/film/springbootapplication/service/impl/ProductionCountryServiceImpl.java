package film.springbootapplication.service.impl;

import film.springbootapplication.model.ProductionCompany;
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
//    public ProductionCompany updateProductionById(Long id) {
//        return productionCountryRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException(String.format("ProductionCompany with ID [%d] not found", id)));
//    }

    @Autowired
    private ProductionCountryRepository productionCountryRepository;

    @Override
    public List<ProductionCompany> getAll() {
        return productionCountryRepository.findAll();
    }

    @Override
    public Optional<ProductionCompany> getById(Long id) {
        return productionCountryRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        productionCountryRepository.deleteById(id);
    }

    @Override
    public ProductionCompany create(ProductionCompany movie) {
        return productionCountryRepository.saveAndFlush(movie);
    }

    @Override
    public ProductionCompany update(ProductionCompany movie) {
        return null;
    }
}
