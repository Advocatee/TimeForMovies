package film.springbootapplication.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class UpdateMovieDto extends BaseDto {

    private Date releaseDate;
    private Integer runtime;
    private String voteAverage;
    private Set<String> genreList;
    private List<String> country;
}
