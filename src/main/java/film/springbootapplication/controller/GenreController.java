package film.springbootapplication.controller;

import film.springbootapplication.dto.UpdateGenreDto;
import film.springbootapplication.model.Genre;
import film.springbootapplication.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping(value = "/genres")
    public List<Genre> movieList() {
        return genreService.getAllGenres();
    }

    @GetMapping(value = "/{id}")
    public Genre getById(@PathVariable Long id) {
        return genreService.getGenreById(id).orElseThrow(() -> new EntityNotFoundException("No Genre with such ID"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createGenre(@RequestBody Genre genre) {
        genreService.createGenre(genre);
    }

    @PostMapping()
    public Genre addGenre(@RequestBody UpdateGenreDto dto) {
        //TODO Add ModelMapper

        Genre g = new Genre();
        g.setDataSource(dto.getDataSource());
        g.setDataSourceId(dto.getDataSourceId());
        g.setName(dto.getName());

        return genreService.createGenre(g);
    }

    @DeleteMapping(value = "/genre/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        genreService.deleteGenre(id);
    }

    @PutMapping
    public Genre updateMovie(@RequestBody Genre genre) {
        return genreService.updateGenre(genre);
    }

    @PutMapping("/genreUpdate/{id}")
    public Genre update(@PathVariable Long id) {
        return genreService.updateById(id);
    }


}
