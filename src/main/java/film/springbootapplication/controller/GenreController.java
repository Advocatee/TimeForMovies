package film.springbootapplication.controller;

import film.springbootapplication.dto.UpdateGenreDto;
import film.springbootapplication.model.Genre;
import film.springbootapplication.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping( value = "/genres")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping()
    public List<Genre> movieList() {

        return genreService.getAllGenres();

    }

    @GetMapping(value = "/{id}")
    public Genre getById(@PathVariable Long id) {
        return genreService.getGenreById(id).orElseThrow(() -> new EntityNotFoundException("No Genre with such ID"));
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




}
