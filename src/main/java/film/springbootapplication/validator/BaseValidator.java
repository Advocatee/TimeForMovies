package film.springbootapplication.validator;

import film.springbootapplication.dto.BaseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.GenericTypeResolver;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Slf4j
public class BaseValidator <T extends BaseDto> implements Validator {

    private Class<T> clazz;

    public BaseValidator() {
        this.clazz = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseValidator.class);
    }

    @Override   // Будет вызываться автоматически, при создании
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        T target = (T) object;
        commonValidate(target, errors);
    }

    protected void commonValidate(T target, Errors errors) {

    }


}
