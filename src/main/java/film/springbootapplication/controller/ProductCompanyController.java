package film.springbootapplication.controller;

import film.springbootapplication.dto.InfoProductCompanyDto;
import film.springbootapplication.dto.UpdateProductCompanyDto;
import film.springbootapplication.model.Genre;
import film.springbootapplication.model.ProductionCompany;
import film.springbootapplication.service.ProductionCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductCompanyController extends BaseController<ProductionCompanyService> {


    private ProductionCompanyService service;

    @Autowired
    public ProductCompanyController(ProductionCompanyService service) {
        this.service = service;
    }

    @GetMapping(value = "/companies")
    public List<ProductionCompany> productionCountryList() {
        return service.getAll();
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
    public void createProductCompany(@RequestBody ProductionCompany company) {
        service.create(company);
    }

    @PutMapping("/companies/{id}")
    public ProductionCompany update(@PathVariable UpdateProductCompanyDto dto) {
        ProductionCompany company = getModelMapper().map(dto, ProductionCompany.class);
        return service.update(company);
    }

}