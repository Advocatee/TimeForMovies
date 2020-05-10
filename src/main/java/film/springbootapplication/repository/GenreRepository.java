package film.springbootapplication.repository;

import film.springbootapplication.model.Genre;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface GenreRepository extends BaseRepository<Genre> {

    Genre findByIdAndActive(Long id, boolean active);

    @Query("from Genre where (:updated is null or updated = :updated) and id = :id ")
    Genre findGenreById(Long id, Date updated);

//    Optional<Genre> findByName(String name);
}
