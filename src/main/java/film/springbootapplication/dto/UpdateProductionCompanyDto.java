package film.springbootapplication.dto;

import lombok.Data;

@Data
public class UpdateProductionCompanyDto extends BaseDto {

    private String dataSourceId;
    private String name;
    private String country;
}
