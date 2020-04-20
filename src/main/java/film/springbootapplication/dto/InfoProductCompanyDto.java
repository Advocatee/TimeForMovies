package film.springbootapplication.dto;

import lombok.Data;

import java.util.List;

@Data
public class InfoProductCompanyDto {
    private String name;
    private String productCountry;
    private String dataSourceId;
    private List<String> movie;
}
