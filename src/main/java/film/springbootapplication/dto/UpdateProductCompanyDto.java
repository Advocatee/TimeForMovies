package film.springbootapplication.dto;

import film.springbootapplication.model.Movie;
import lombok.Data;

import java.util.List;

@Data
public class UpdateProductCompanyDto {

    private String name;
    private String dataSourceId;
    private List<Movie> movies;
}
