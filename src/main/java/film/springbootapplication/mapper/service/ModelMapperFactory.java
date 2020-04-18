package film.springbootapplication.mapper.service;

import film.springbootapplication.mapper.MovieMapper;

public interface ModelMapperFactory {
    MovieMapper createMapper();
}
