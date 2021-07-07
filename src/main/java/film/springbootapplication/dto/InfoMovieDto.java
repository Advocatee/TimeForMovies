package film.springbootapplication.dto;

import film.springbootapplication.model.Genre;
import lombok.Data;

import java.util.List;

@Data
public class InfoMovieDto extends BaseDto {

    private List<Genre> genreList;
}
