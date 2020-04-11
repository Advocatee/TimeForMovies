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

    @Autowired
    private ProductionCountryRepository productionCountryRepository;

//    @Override
//    public ProductionCountry updateProductionById(Long id) {
//        return productionCountryRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException(String.format("ProductionCountry with ID [%d] not found", id)));
//    }

    // --------------------------------------------------------------------

    @Override
    public List<ProductionCountry> getAll() {
        return productionCountryRepository.findAll();
    }

    @Override
    public Optional<ProductionCountry> getById(Long id) {
        return productionCountryRepository.findById(id);
    }

    @Override
    public Long delete(Long id) {

        //TODO не удалять а помечать active = false и ставить дату в поле updated
        productionCountryRepository.deleteById(id);
        return id;
    }

    @Override
    public ProductionCountry create(ProductionCountry productionCountry) {
        return productionCountryRepository.save(productionCountry);
    }

    @Override
    public ProductionCountry update(ProductionCountry productionCountry) {
        return null;
    }
}
