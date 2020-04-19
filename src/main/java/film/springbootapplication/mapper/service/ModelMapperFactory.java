package film.springbootapplication.mapper.service;


import film.springbootapplication.mapper.CustomModelMapper;

public interface ModelMapperFactory {
    CustomModelMapper createMapper();
}
