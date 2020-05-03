package film.springbootapplication.service;

import film.springbootapplication.model.Genre;

import java.util.Optional;

public interface GenreService extends BaseService<Genre> {

    Optional<Genre> findByName(String genreName);
}
