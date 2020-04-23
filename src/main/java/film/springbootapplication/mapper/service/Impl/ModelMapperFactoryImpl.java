package film.springbootapplication.mapper.service.Impl;


import film.springbootapplication.dto.*;
import film.springbootapplication.mapper.CustomModelMapper;
import film.springbootapplication.mapper.service.ModelMapperFactory;
import film.springbootapplication.model.Genre;
import film.springbootapplication.model.Movie;
import film.springbootapplication.model.ProductionCompany;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ModelMapperFactoryImpl implements ModelMapperFactory {

    private CustomModelMapper mapper;

    public ModelMapperFactoryImpl() {
    }

    @Override
    public CustomModelMapper createMapper() {
        return mapper;
    }

    @PostConstruct
    public ModelMapper createModelMapper() {
        mapper = new CustomModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        mapper.createTypeMap(Genre.class, InfoGenreDto.class)
                .addMappings(mapping -> mapping.using(movieToMovieTitleConverter).map(Genre::getMovies, InfoGenreDto::setMovies));

        mapper.createTypeMap(ProductionCompany.class, InfoProductCompanyDto.class)
                .addMappings(mapping -> mapping.using(movieToMovieTitleConverter).map(ProductionCompany::getMovies, InfoProductCompanyDto::setMovie));

        mapper.createTypeMap(Movie.class, InfoMovieDto.class)
                .addMappings(mapping -> mapping.using(genreListToGenreListConverter).map(Movie::getGenreList, InfoMovieDto::setGenreList));

        mapper.createTypeMap(ProductionCompany.class,UpdateProductCompanyDto.class)
                .addMappings(mapping -> mapping.using(movieToMovieListConverter).map(ProductionCompany::getMovies,UpdateProductCompanyDto::setMovies));

        return mapper;
    }


    private Converter<Set<Movie>, List<InfoMovieDto>> movieToMovieTitleConverter = ctx -> ctx.getSource().stream().map(Movie::getTitle).collect(Collectors.toList());

    private Converter<Set<Genre>, List<Genre>> genreListToGenreListConverter = ctx -> ctx.getSource().stream().map(Movie::getTitle).collect(Collectors.toList());

//    private Converter<Set<Movie>, List<Movie>> movieToMovieInfoConverter = ctx -> ctx.getSource().stream().map(ProductionCompany::getMovies).collect(Collectors.toList());

    private Converter<Set<Movie>, List<Movie>> movieToMovieListConverter = (ctx) -> ctx.getSource().stream().map(it -> it.getTitle()).collect(Collectors.toList());

}
