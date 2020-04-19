package film.springbootapplication.mapper.service;


import org.modelmapper.ModelMapper;

public interface ModelMapperFactory {
    ModelMapper createMapper();
}
