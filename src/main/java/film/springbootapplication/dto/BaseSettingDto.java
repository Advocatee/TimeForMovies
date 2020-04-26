package film.springbootapplication.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BaseSettingDto extends BaseDto {

    @NotEmpty
    private String name;
}
