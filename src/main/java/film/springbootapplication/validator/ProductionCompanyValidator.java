package film.springbootapplication.validator;

import film.springbootapplication.dto.UpdateProductionCompanyDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class ProductionCompanyValidator extends BaseValidator<UpdateProductionCompanyDto> {

    @Override
    protected void commonValidate(UpdateProductionCompanyDto target, Errors errors) {
        if (target.getName().isEmpty()) {
            errors.rejectValue("name", "Name could not be empty :" + target.getName());
        }
        if (target.getCountry().isEmpty()) {
            errors.rejectValue("country", "Country should't be empty");
        }
    }
}
