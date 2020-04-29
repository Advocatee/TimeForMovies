package film.springbootapplication.validator;

import film.springbootapplication.dto.UpdateMovieDto;
import org.springframework.validation.Errors;

public class MovieValidator extends BaseValidator<UpdateMovieDto> {

    @Override
    protected void commonValidate(UpdateMovieDto target, Errors errors) {
        if (target.getName().isEmpty()) {
            errors.rejectValue("name", "Name could not be empty :" + target.getName());
        }
        if (target.getId() == null || target.getId() < 0) {
            errors.reject("id", "Id could not be empty and must be > 0 ");
        }
    }
}