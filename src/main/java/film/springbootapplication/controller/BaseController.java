package film.springbootapplication.controller;

import film.springbootapplication.controller.exception.AppControllerException;
import film.springbootapplication.dto.BaseDto;
import film.springbootapplication.mapper.CustomModelMapper;
import film.springbootapplication.model.User;
import film.springbootapplication.service.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class BaseController<T extends BaseService> {

    @Autowired
    private CustomModelMapper modelMapper;

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    protected <T extends BaseDto> void validate(T dto, Validator validator) {
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(dto, dto.getClass().getName());
        validator.validate(dto, result);
        checkResult(result);
    }

    private void checkResult(BindingResult result) {
        if (result.hasErrors()) {
            throw new AppControllerException(result);
        }
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String Home(){
//        return "forward:/genres";
//    }

//    @RequestMapping({"/"})
//    public String execute(User user) {
//        if (user.getUsername().isEmpty()) {
//            return "forward:/login";
//        } else {
//            return "forward:/genres";
//        }
//    }


}
