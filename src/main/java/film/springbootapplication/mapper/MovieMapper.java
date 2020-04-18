package film.springbootapplication.mapper;

import film.springbootapplication.dto.InfoGenreDto;
import film.springbootapplication.dto.MovieDto;
import film.springbootapplication.model.Genre;
import film.springbootapplication.model.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MovieMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Movie toEntity(MovieDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Movie.class);
    }

    public MovieDto toDto(MovieDto entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, MovieDto.class);
    }

//    public ModelMapper createTypeMap(Class<Genre> genreClass, Class<InfoGenreDto> infoGenreDtoClass) {
//        return null;
//    }
}
