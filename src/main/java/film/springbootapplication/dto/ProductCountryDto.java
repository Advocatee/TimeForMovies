package film.springbootapplication.dto;

import film.springbootapplication.model.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductCountryDto {

    private String name;
    private String productCountry;
    private String dataSourceId;
    private Movie movie;
}
