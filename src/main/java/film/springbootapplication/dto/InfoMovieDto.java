package film.springbootapplication.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class InfoMovieDto {
    private String title;
    private Date releaseDate;
    private Integer runtime;
    private String voteAverage;
    private Set<String> genres;
    private List<String> countries;
}
