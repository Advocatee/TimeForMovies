package film.springbootapplication.controller;

import film.springbootapplication.model.ProductionCountry;
import film.springbootapplication.service.ProductionCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class ProductCountryController {

    @Autowired
    private ProductionCountryService service;

    @GetMapping(value = "/productCountry")
    public List<ProductionCountry> productionCountryList() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    public ProductionCountry getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow(() -> new EntityNotFoundException("No ProductCountry with such ID"));
    }

    @DeleteMapping(value = "/productCountry/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(value = "/countries")
    public void createProductCountry(@RequestBody ProductionCountry productionCountry) {
        service.create(productionCountry);
    }
}
