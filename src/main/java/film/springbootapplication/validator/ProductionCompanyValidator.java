package film.springbootapplication.validator;

import film.springbootapplication.dto.UpdateProductionCompanyDto;
import org.springframework.validation.Errors;

public class ProductionCompanyValidator extends BaseValidator<UpdateProductionCompanyDto> {

    @Override
    protected void commonValidate(UpdateProductionCompanyDto target, Errors errors) {
        if (target.getName().isEmpty()) {
            errors.rejectValue("name", "Name could not be empty :" + target.getName());
        }
        if (target.getId() == null || target.getId() < 0) {
            errors.reject("id", "Id could not be empty and must be > 0 ");
        }
    }
}
