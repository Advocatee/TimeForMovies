package film.springbootapplication.controller;

import film.springbootapplication.dto.InfoGenreDto;
import film.springbootapplication.dto.UpdateGenreDto;
import film.springbootapplication.model.Genre;
import film.springbootapplication.service.GenreService;
import film.springbootapplication.validator.GenreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GenreController extends BaseController<GenreService> {

    private final GenreService service;

    @Autowired
    public GenreController(GenreService service) {
        this.service = service;
    }

    @GetMapping(value = "/genres")
    public List<Genre> findGenres() {
        return service.getAll();
    }

    @GetMapping(value = "/genres/{id}")
    public InfoGenreDto findGenre(@PathVariable Long id) {
        Optional<Genre> genre = service.getById(id);
        return getModelMapper().map(genre, InfoGenreDto.class);
    }

    @PostMapping("/genres")
    public Genre addGenre(@RequestBody Genre genre) {
        return service.create(genre);
    }

    @DeleteMapping(value = "/genres/{id}")
    public void removeGenre(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping(value = "/genres/{id}")
    public Genre updateGenre(@RequestBody UpdateGenreDto genre) {
        validate(genre, new GenreValidator());

        //        return service.update(genre);
        return null;
    }
}
