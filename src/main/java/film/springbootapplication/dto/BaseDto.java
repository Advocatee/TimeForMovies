package film.springbootapplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public abstract class BaseDto {
    @JsonIgnore
    private Long id;
    private String name;
}
