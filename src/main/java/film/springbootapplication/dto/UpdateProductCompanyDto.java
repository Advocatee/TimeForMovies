package film.springbootapplication.dto;

import film.springbootapplication.model.Movie;
import lombok.Data;

import java.util.List;

@Data
public class UpdateProductCompanyDto extends BaseDto {

    private String dataSourceId;
    private String name;
    private String country;
}
