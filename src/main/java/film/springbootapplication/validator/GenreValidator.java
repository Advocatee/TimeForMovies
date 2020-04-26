package film.springbootapplication.validator;

import film.springbootapplication.dto.UpdateGenreDto;
import org.springframework.validation.Errors;

public class GenreValidator extends BaseValidator<UpdateGenreDto> {

    @Override
    protected void commonValidate(UpdateGenreDto target, Errors errors) {
        if(target.getName().isEmpty()) {
            errors.rejectValue("name", "Name could not be empty :" + target.getName());
        }
    }
}
