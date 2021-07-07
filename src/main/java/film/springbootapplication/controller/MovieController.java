package film.springbootapplication.controller;

import film.springbootapplication.model.Movie;
import film.springbootapplication.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/movies")
    public List<Movie> findMovies() {
        return movieService.getAll();
    }

    @PostMapping(value = "/movies")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.create(movie);
    }

    @DeleteMapping(value = "/movies/{id}")
    public void removeMovie(@PathVariable Long id) {
        movieService.delete(id);
    }

    @GetMapping(value = "/movies/{id}")
    public Movie findMovie(@PathVariable Long id) {
        return movieService.getById(id).orElseThrow(() -> new EntityNotFoundException("No Movies with such ID"));
    }

    @PutMapping(value = "/movies/{id}")
    public Movie updateMovie(@PathVariable Long id) {
        return movieService.update(null);
    }

}
