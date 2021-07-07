package film.springbootapplication.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    private ModelMapper modelMapper;

    public ModelMapper getModelMapper() {
        return modelMapper;
    }
}
