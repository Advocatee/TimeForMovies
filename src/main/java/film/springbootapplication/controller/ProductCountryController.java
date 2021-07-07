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

    @GetMapping(value = "/countries")
    public List<ProductionCountry> productionCountryList() {
        return service.getAll();
    }

    @GetMapping(value = "/countries/{id}")
    public ProductionCountry getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow(() -> new EntityNotFoundException("No ProductCountry with such ID"));
    }

    @DeleteMapping(value = "/countries/{id}")
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(value = "/countries")
    public void createProductCountry(@RequestBody ProductionCountry productionCountry) {
        service.create(productionCountry);
    }

    @PutMapping("/countries/{id}")
    public ProductionCountry update(@PathVariable ProductionCountry id) {
        return service.update(id);
    }

}
