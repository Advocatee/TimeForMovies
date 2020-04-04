package film.springbootapplication.repository;

import film.springbootapplication.model.Genre;

public interface GenreRepository extends BaseRepository<Genre> {

    Genre findByIdAndActive(Long id, boolean active);

    Genre findGenreByIdAndUpdated(Long id);

}
