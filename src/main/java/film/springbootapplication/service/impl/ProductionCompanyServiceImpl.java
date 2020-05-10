package film.springbootapplication.service.impl;


import film.springbootapplication.model.ProductionCompany;
import film.springbootapplication.repository.ProductionCountryRepository;
import film.springbootapplication.service.ProductionCompanyService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductionCompanyServiceImpl implements ProductionCompanyService {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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
    public Long delete(Long id) {
        ProductionCompany activeProductCompany = productionCountryRepository.findByIdAndActive(id, true);
        activeProductCompany.setActive(false);
        productionCountryRepository.save(activeProductCompany);
        return activeProductCompany.getId();
    }

    @Override
    public ProductionCompany create(ProductionCompany productionCompany) {
        return productionCountryRepository.save(productionCompany);
    }

    @Override
    public ProductionCompany update(ProductionCompany productionCompany) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(productionCompany);
//        return productionCountryRepository.saveAndFlush(productionCompany);
        return productionCompany;
    }

    @Override
    public Optional<ProductionCompany> findByCompany(String it) {
//        return Optional.empty();
        return productionCountryRepository.findByName(it);
    }
}
