package film.springbootapplication.dto;

import film.springbootapplication.model.Movie;
import lombok.Data;

@Data
public class ProductCountryDto {
    private String name;
    private String productCountry;
    private String dataSourceId;
    private Movie movie;
}
