package film.springbootapplication.dto;

import lombok.Data;

import java.util.List;

@Data
public class InfoProductCompanyDto extends BaseDto {

    private String productCompany;
    private String dataSourceId;
    private String country;
    private List<InfoMovieDto> movie;
}
