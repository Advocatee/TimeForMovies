package film.springbootapplication.controller;

import film.springbootapplication.model.Genre;
import film.springbootapplication.model.Movie;
import film.springbootapplication.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController(value = "/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/movies")
    public List<Movie> movieList() {
        return movieService.getAllMovies();
    }

    @GetMapping(value = "/{id}")
    public Movie getById(@PathVariable Long id) {
        return movieService.getMovieById(id).orElseThrow(() -> new EntityNotFoundException("No Movies with such ID"));
    }

    @DeleteMapping(value = "/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovie(@RequestBody Movie movie) {
        movieService.createMovie(movie);
    }

    @PutMapping
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

}
