package film.springbootapplication.controller;

import film.springbootapplication.service.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController <T extends BaseService> {

//    T service;

//    public BaseController(T service) {
//        this.service = service;
//    }

    @Autowired
    private ModelMapper modelMapper;

    public ModelMapper getModelMapper() {
        return modelMapper;
    }
}
