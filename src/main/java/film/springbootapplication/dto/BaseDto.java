package film.springbootapplication.dto;

import lombok.Data;

@Data
public abstract class BaseDto {

    private Long id;
    private String name;
}
