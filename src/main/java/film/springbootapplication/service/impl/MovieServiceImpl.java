package film.springbootapplication.service.impl;

import film.springbootapplication.model.Movie;
import film.springbootapplication.repository.MovieRepository;
import film.springbootapplication.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Transactional
    @Override
    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
