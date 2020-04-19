package film.springbootapplication.controller;

import film.springbootapplication.mapper.CustomModelMapper;
import film.springbootapplication.service.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController <T extends BaseService> {

    @Autowired
    private CustomModelMapper modelMapper;

    public ModelMapper getModelMapper() {
        return modelMapper;
    }
}
