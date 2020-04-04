package film.springbootapplication.dto;

import film.springbootapplication.model.Genre;
import film.springbootapplication.model.ProductionCountry;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class MovieDto {
    @Autowired
    private ModelMapper mapper;

    private String title;
    private Date releaseDate;
    private Integer runtime;
    private String voteAverage;
    private Set<Genre> genreList;
    private List<ProductionCountry> country;
}
