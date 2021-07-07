package film.springbootapplication.repository;

import film.springbootapplication.model.Genre;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;
import java.util.List;

public interface GenreRepository extends BaseRepository<Genre> {

    Genre findByIdAndActive(Long id, boolean active);

    @Query("from Genre as g where g.active = true  ")
    List<Genre> findByActive();

    Genre findGenreByName(String name);

    @Query("from Genre where (:updated is null or updated = :updated) and id = :id ")
    Genre findGenreById(Long id, Date updated);

    Genre findGenreById(Long id);

}
