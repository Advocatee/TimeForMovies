package film.springbootapplication.mapper.service.Impl;

import film.springbootapplication.dto.*;
import film.springbootapplication.mapper.CustomModelMapper;
import film.springbootapplication.mapper.service.ModelMapperFactory;
import film.springbootapplication.model.Genre;
import film.springbootapplication.model.Movie;
import film.springbootapplication.model.ProductionCompany;
import film.springbootapplication.service.GenreService;
import film.springbootapplication.service.ProductionCompanyService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityExistsException;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ModelMapperFactoryImpl implements ModelMapperFactory {

    private CustomModelMapper mapper;

    @Autowired
    private GenreService genreService;

    @Autowired
    private ProductionCompanyService productionCompanyService;

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

        mapper.createTypeMap(ProductionCompany.class, InfoProductCompanyDto.class)
                .addMappings(mapping -> mapping.using(movieToMovieTitleConverter).map(ProductionCompany::getMovies, InfoProductCompanyDto::setMovie));

        mapper.createTypeMap(Movie.class, InfoMovieDto.class)
                .addMappings(mapping -> mapping.using(genreListToGenreListConverter).map(Movie::getGenreList, InfoMovieDto::setGenreList));

        mapper.createTypeMap(UpdateMovieDto.class, Movie.class)
                .addMappings(mapping -> mapping.using(productCompanyNameToProductCompanyConverter).map(UpdateMovieDto::getCountry, Movie::setCountry))
                .addMappings(mapping -> mapping.using(genreNameToGenreConverter).map(UpdateMovieDto::getGenreList, Movie::setGenreList));


        return mapper;
    }

    private Converter<Set<Movie>, List<String>> movieToMovieTitleConverter = ctx -> Objects.nonNull(ctx.getSource()) && ctx.getSource().isEmpty()
            ? ctx.getSource().stream().map(Movie::getName).collect(Collectors.toList())
            : new ArrayList<>();

    private Converter<Set<Genre>, List<String>> genreListToGenreListConverter = ctx -> ctx.getSource().stream().map(Genre::getName).collect(Collectors.toList());

    private Converter<Set<String>, Set<Genre>> genreNameToGenreConverter = ctx -> ctx.getSource().parallelStream().map(it -> {
        Optional<Genre> found = genreService.findByName(it);
        return found.orElseThrow(EntityExistsException::new);
    }).collect(Collectors.toSet());

    private Converter<List<String>, List<ProductionCompany>> productCompanyNameToProductCompanyConverter = ctx -> ctx.getSource().parallelStream().map(it ->
    {
        Optional<ProductionCompany> found = productionCompanyService.findByCompany(it);
        return found.orElseThrow(EntityExistsException::new);
    }).collect(Collectors.toList());

}
