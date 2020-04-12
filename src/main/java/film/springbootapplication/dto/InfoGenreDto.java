package film.springbootapplication.dto;

import lombok.Data;

import java.util.List;

@Data
public class InfoGenreDto {
    private String name;
    private Long id;
    private List<String> movies;
}
