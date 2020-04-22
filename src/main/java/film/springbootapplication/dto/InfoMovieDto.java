package film.springbootapplication.dto;

import film.springbootapplication.model.Genre;
import lombok.Data;

import java.util.List;

@Data
public class InfoMovieDto {

    private String title;
    private Long id;
    private List<Genre> genreList;
}
