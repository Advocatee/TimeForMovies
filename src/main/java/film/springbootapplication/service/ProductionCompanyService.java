package film.springbootapplication.service;

import film.springbootapplication.model.ProductionCompany;

import java.util.List;
import java.util.Optional;

public interface ProductionCompanyService extends BaseService<ProductionCompany> {

    Optional<ProductionCompany> findByCompany(String it);

    List<ProductionCompany> findByActive();
}
