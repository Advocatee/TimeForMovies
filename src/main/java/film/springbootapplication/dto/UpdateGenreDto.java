package film.springbootapplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UpdateGenreDto {
    private String name;
    private String dataSource;
    private String dataSourceId;
}
