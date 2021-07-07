package film.springbootapplication.validator;

import film.springbootapplication.dto.UpdateMovieDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class MovieValidator extends BaseValidator<UpdateMovieDto> {

    @Override
    protected void commonValidate(UpdateMovieDto target, Errors errors) {
        if (target.getName().isEmpty()) {
            errors.rejectValue("name", "Name could not be empty :" + target.getName());
        }
        if (target.getRuntime() < 0) {
            errors.rejectValue("runtime", "Runtime must be higher than 0 : " + target.getRuntime());
        }
    }
}