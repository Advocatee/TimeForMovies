package film.springbootapplication.service;

import film.springbootapplication.model.Genre;

import java.util.List;

public interface GenreService extends BaseService<Genre> {

    Genre findByName(String genreName);

    List<Genre> findByActive();
}
