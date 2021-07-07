package film.springbootapplication.repository;

import film.springbootapplication.model.Movie;

public interface MovieRepository  extends BaseRepository<Movie> {

    Movie findMovieById(Long id);

}
