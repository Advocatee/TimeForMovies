package film.springbootapplication.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
public abstract class BaseDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
