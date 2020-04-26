package film.springbootapplication.controller;

import film.springbootapplication.dto.BaseDto;
import film.springbootapplication.mapper.CustomModelMapper;
import film.springbootapplication.service.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;

public class BaseController<T extends BaseService> {

    @Autowired
    private CustomModelMapper modelMapper;

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    protected <T extends BaseDto> void validate(T entity, Validator validator) {
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(entity, entity.getClass().getName());
        validator.validate(entity, result);
    }
}
