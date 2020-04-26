package film.springbootapplication.dto;

import lombok.Data;

@Data
public class UpdateGenreDto extends BaseDto {

    private String dataSource;
    private String dataSourceId;
}