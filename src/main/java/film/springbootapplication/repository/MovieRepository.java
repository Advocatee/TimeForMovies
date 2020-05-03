package film.springbootapplication.repository;

import film.springbootapplication.model.Movie;

public interface MovieRepository  extends BaseRepository<Movie> {

    Movie findByIdAndActive(Long id, boolean active);

    Movie findMovieById(Long id);

}
