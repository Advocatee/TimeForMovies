package film.springbootapplication.controller;

import film.springbootapplication.dto.BaseDto;
import film.springbootapplication.mapper.CustomModelMapper;
import film.springbootapplication.service.BaseService;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

public class BaseController<T extends BaseService> {

    @Autowired
    private CustomModelMapper modelMapper;

    @Autowired
    private BaseExceptionHandler baseExceptionHandler;

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    protected <T extends BaseDto> void validate(T dto, Validator validator) {
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(dto, dto.getClass().getName());
        validator.validate(dto, result);
    }

    private void checkResult(BindingResult result){
        checkBindingResult(result);
    }

    private void checkBindingResult(BindingResult result){
        if (result.hasErrors()){
            throw new  baseExceptionHandler.CustomException(result);
        }
    }
}
