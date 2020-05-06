package film.springbootapplication.dto;

import lombok.Data;

@Data
public class UpdateGenreDto extends BaseDto {

    private String dataSource;  //записываем откуда пришел этот жанр
    private String dataSourceId; //Id под которым он находится в стороннем сервисе
}