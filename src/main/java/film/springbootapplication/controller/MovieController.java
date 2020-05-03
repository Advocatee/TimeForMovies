package film.springbootapplication.controller;

import film.springbootapplication.dto.InfoMovieDto;
import film.springbootapplication.dto.UpdateMovieDto;
import film.springbootapplication.model.Movie;
import film.springbootapplication.service.MovieService;
import film.springbootapplication.validator.MovieValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController extends BaseController<MovieService> {

    private final MovieService service;

    private final MovieValidator movieValidator;

    @Autowired
    public MovieController(MovieService service, MovieValidator movieValidator) {
        this.service = service;
        this.movieValidator = movieValidator;
    }

    @GetMapping(value = "/movies")
    public List<Movie> findMovies() {
        return service.getAll();
    }

    @PostMapping(value = "/movies")
    public Movie createMovie(@RequestBody UpdateMovieDto dto) {
        validate(dto, movieValidator);
        Movie createMovie = getModelMapper().map(dto, Movie.class);
        return service.create(createMovie);
    }

    @DeleteMapping(value = "/movies/{id}")
    public void removeMovie(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping(value = "/movies/{id}")
    public InfoMovieDto findMovie(@PathVariable Long id) {
        Optional<Movie> movie = service.getById(id);
        return getModelMapper().map(movie, InfoMovieDto.class);
    }

    @PutMapping(value = "/movies/{id}")
    public Movie updateMovie(@PathVariable UpdateMovieDto movieDto) {
        validate(movieDto, new MovieValidator());
        Movie movie = getModelMapper().map(movieDto, Movie.class);
        return service.update(movie);
    }

}
