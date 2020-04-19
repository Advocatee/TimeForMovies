package film.springbootapplication.dto;

import film.springbootapplication.model.Genre;
import film.springbootapplication.model.ProductionCompany;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class MovieDto {
    private String title;
    private Date releaseDate;
    private Integer runtime;
    private String voteAverage;
    private Set<Genre> genreList;
    private List<ProductionCompany> country;
}
