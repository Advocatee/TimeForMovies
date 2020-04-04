package film.springbootapplication.controller;

import film.springbootapplication.model.Movie;
import film.springbootapplication.model.ProductionCountry;
import film.springbootapplication.service.ProductionCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class ProductCountryController {

    @Autowired
    private ProductionCountryService service;

    @GetMapping(value = "/productCountry")
    public List<ProductionCountry> productionCountryList() {
        return service.getAllProductionCountry();
    }

    @GetMapping(value = "/{id}")
    public ProductionCountry getById(@PathVariable Long id) {
        return service.getProductionCountryById(id).orElseThrow(() -> new EntityNotFoundException("No ProductCountry with such ID"));
    }

    @DeleteMapping(value = "/productCountry/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteProductionCountry(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProductCountry(@RequestBody ProductionCountry productionCountry) {
        service.createProductionCountry(productionCountry);
    }

    @PutMapping
    public ProductionCountry updateProductCountry(@RequestBody ProductionCountry productionCountry) {
        return service.updateProductionCountry(productionCountry);
    }

    @PutMapping("/productCountry/{id}")
    public ProductionCountry update(@PathVariable Long id) {
        return service.updateProductionById(id);
    }

}
