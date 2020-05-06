package film.springbootapplication.validator;

import film.springbootapplication.dto.UpdateGenreDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class GenreValidator extends BaseValidator<UpdateGenreDto> {

    @Override
    protected void commonValidate(UpdateGenreDto target, Errors errors) {
        if(target.getName().isEmpty()) {
            errors.rejectValue("name", "Name could not be empty :" + target.getName());
        }
        if (target.getDataSourceId().isEmpty()) {
            errors.rejectValue("dataSourceId","DataSourceId couldn't be empty" + target.getDataSourceId());
        }
        if (target.getDataSource().isEmpty()) {
            errors.rejectValue("dataSource","DataSource couldn't be empty" + target.getDataSource());
        }
    }
}
