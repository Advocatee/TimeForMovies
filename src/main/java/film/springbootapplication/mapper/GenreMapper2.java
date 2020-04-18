package film.springbootapplication.mapper;

import film.springbootapplication.dto.InfoGenreDto;
import film.springbootapplication.dto.MovieDto;
import film.springbootapplication.model.Genre;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class GenreMapper2 {

    @Autowired
    private ModelMapper modelMapper;

    public Genre toEntity(InfoGenreDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Genre.class);
    }

    public InfoGenreDto toDto(InfoGenreDto entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, InfoGenreDto.class);
    }
}
