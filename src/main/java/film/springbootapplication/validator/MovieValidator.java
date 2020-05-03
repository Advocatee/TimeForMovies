package film.springbootapplication.validator;

import film.springbootapplication.dto.UpdateMovieDto;
import film.springbootapplication.model.Genre;
import film.springbootapplication.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class MovieValidator extends BaseValidator<UpdateMovieDto> {

    @Autowired
    private GenreService genreService;

    @Override
    protected void commonValidate(UpdateMovieDto target, Errors errors) {
//        Genre genre = genreService.getByName(target.getGenreList().stream().findFirst());
        if (target.getName().isEmpty()) {
            errors.rejectValue("name", "Name could not be empty :" + target.getName());
        }
        if (target.getId() == null || target.getId() < 0) {
            errors.reject("id", "Id could not be empty and must be > 0 ");
        }
    }
}