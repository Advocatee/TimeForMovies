package film.springbootapplication.dto;

import film.springbootapplication.model.Genre;
import film.springbootapplication.model.ProductionCountry;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class MovieDto {
    private String title;
    private Date releaseDate;
    private Integer runtime;
    private String voteAverage;
    private Set<Genre> genreList;
    private List<ProductionCountry> country;
}
