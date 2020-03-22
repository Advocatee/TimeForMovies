package film.springbootapplication.service;

import film.springbootapplication.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {

    List<Genre> getAllGenres();

    Optional<Genre> getGenreById(Long id);

    void deleteGenre(Long id);

    Genre createGenre(Genre genre);

    Genre updateGenre(Genre genre);

}
