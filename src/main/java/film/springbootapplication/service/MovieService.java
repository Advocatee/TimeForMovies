package film.springbootapplication.service;

import film.springbootapplication.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> getAllMovies();

    Optional<Movie> getMovieById(Long id);

    void deleteMovie(Long id);

    Movie createMovie(Movie movie);

    Movie updateMovie(Movie movie);

    Movie updateById(Long id);


}
