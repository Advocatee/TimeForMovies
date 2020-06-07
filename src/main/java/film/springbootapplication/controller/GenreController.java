package film.springbootapplication.controller;

import film.springbootapplication.dto.InfoGenreDto;
import film.springbootapplication.dto.UpdateGenreDto;
import film.springbootapplication.model.Genre;
import film.springbootapplication.service.GenreService;
import film.springbootapplication.validator.GenreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@RestController
public class GenreController extends BaseController<GenreService> {

    private final GenreService service;
    private final GenreValidator genreValidator;

    @Autowired
    public GenreController(GenreService service, GenreValidator genreValidator) {
        this.service = service;
        this.genreValidator = genreValidator;
    }

    @GetMapping(value = "/genres")
    public List<Genre> findGenres() {
        return service.findByActive();
    }

    @GetMapping(value = "/genres/{id}")
    public InfoGenreDto findGenre(@PathVariable Long id) {
        Genre genre = service.getById(id).orElseThrow(EntityNotFoundException::new);
        return getModelMapper().map(genre, InfoGenreDto.class);
    }

    @PostMapping("/genres")
    public InfoGenreDto addGenre(@RequestBody UpdateGenreDto dto) {
//        if (dto.getName().isEmpty()) {
//            throw new Exception("Name Should'n be empty");
//        }
        validate(dto, genreValidator);
        Genre genre = getModelMapper().map(dto, Genre.class);
        return getModelMapper().map(service.create(genre), InfoGenreDto.class);
    }

    @DeleteMapping(value = "/genres/{id}")
    public void removeGenre(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping(value = "/genres/{id}")
    public Genre updateGenre(@RequestBody UpdateGenreDto dto, @PathVariable Long id) {
        dto.setId(id);
        validate(dto, genreValidator);
        Genre genre = getModelMapper().map(dto, Genre.class);
        return service.update(genre);
    }
}
