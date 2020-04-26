package film.springbootapplication.dto;

import lombok.Data;

import java.util.List;

@Data
public class InfoGenreDto extends BaseDto {

    private List<InfoMovieDto> movies;
}
