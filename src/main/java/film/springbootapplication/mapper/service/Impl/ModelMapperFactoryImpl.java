package film.springbootapplication.mapper.service.Impl;

import film.springbootapplication.dto.InfoGenreDto;
import film.springbootapplication.mapper.MovieMapper;
import film.springbootapplication.mapper.service.ModelMapperFactory;
import film.springbootapplication.model.Genre;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Qualifier("modelMapperFactory")
public class ModelMapperFactoryImpl implements ModelMapperFactory {

    private MovieMapper mapper;

    public ModelMapperFactoryImpl() {
    }

    @Override
    public MovieMapper createMapper() {
        return mapper;
    }

//    @PostConstruct
//    public ModelMapper createModelMapper() {
//        mapper = new CustomModelMapper();
//        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//
//        mapper.createTypeMap(Genre.class, InfoGenreDto.class)
//                .addMappings(mapping -> mapping.using(settingsToNameConverter).map(ContactReference::getType, InfoContactReferenceDto::setType));
//
//        return modelMapper;
//    }
//
//    private Converter<BaseSettingsEntity, String> settingsToNameConverter = ctx -> ctx.getSource().getName();

}
