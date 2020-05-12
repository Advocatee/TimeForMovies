package film.springbootapplication.service;

import film.springbootapplication.model.Genre;

public interface GenreService extends BaseService<Genre> {

    Genre findByName(String genreName);

    Genre findByActive();
}
