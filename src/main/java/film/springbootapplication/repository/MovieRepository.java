package film.springbootapplication.repository;

import film.springbootapplication.model.Movie;

public interface MovieRepository  extends BaseRepository<Movie> {

    Movie findMovieByIdAndUpdated(Long id);

}
