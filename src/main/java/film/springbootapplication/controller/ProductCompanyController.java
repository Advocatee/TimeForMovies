package film.springbootapplication.controller;

import film.springbootapplication.dto.InfoProductCompanyDto;
import film.springbootapplication.dto.UpdateProductionCompanyDto;
import film.springbootapplication.model.ProductionCompany;
import film.springbootapplication.service.ProductionCompanyService;
import film.springbootapplication.validator.ProductionCompanyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductCompanyController extends BaseController<ProductionCompanyService> {


    private final ProductionCompanyService service;
    private final ProductionCompanyValidator productionCompanyValidator;

    @Autowired
    public ProductCompanyController(ProductionCompanyService service, ProductionCompanyValidator productionCompanyValidator) {
        this.service = service;
        this.productionCompanyValidator = productionCompanyValidator;
    }

    @GetMapping(value = "/companies")
    public List<ProductionCompany> productionCountryList() {
        return service.findByActive();
    }

    @GetMapping(value = "/companies/{id}")
    public InfoProductCompanyDto getById(@PathVariable Long id) {
        Optional<ProductionCompany> company = service.getById(id);
        return getModelMapper().map(company, InfoProductCompanyDto.class);
    }

    @DeleteMapping(value = "/companies/{id}")
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(value = "/companies")
    public InfoProductCompanyDto createProductCompany(@RequestBody UpdateProductionCompanyDto dto) {
        validate(dto, productionCompanyValidator);
        ProductionCompany productionCompany = getModelMapper().map(dto, ProductionCompany.class);
        return getModelMapper().map(service.create(productionCompany), InfoProductCompanyDto.class);
    }

    @PutMapping("/companies/{id}")
    public ProductionCompany update(@RequestBody UpdateProductionCompanyDto dto, @PathVariable Long id) {
        dto.setId(id);
        validate(dto, new ProductionCompanyValidator());
        ProductionCompany company = getModelMapper().map(dto, ProductionCompany.class);
        return service.update(company);
    }

}