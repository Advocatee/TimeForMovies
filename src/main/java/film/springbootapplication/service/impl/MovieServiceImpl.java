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

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public Long delete(Long id) {
        Movie activeMovie = movieRepository.findByIdAndActive(id, true);
        activeMovie.setActive(false);
        movieRepository.save(activeMovie);
        return activeMovie.getId();
    }

    @Override
    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(Movie movie) {
        return movieRepository.saveAndFlush(movie);
    }
}