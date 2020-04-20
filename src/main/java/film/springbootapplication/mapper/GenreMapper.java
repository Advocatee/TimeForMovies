//package film.springbootapplication.mapper;
//
//import film.springbootapplication.dto.InfoGenreDto;
//import film.springbootapplication.model.Genre;
//import film.springbootapplication.repository.GenreRepository;
//import org.modelmapper.Converter;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.Objects;
//
//@Component
//public class GenreMapper {
//
//    private final ModelMapper mapper;
//
//    private final GenreRepository genreRepository;
//
//    @Autowired
//    public GenreMapper(ModelMapper modelMapper, GenreRepository genreRepository) {
//        this.mapper = modelMapper;
//        this.genreRepository = genreRepository;
//    }
//
//    @PostConstruct
//    public void setupMapper() {
//        mapper.createTypeMap(Genre.class, InfoGenreDto.class)
//                .addMappings(m -> m.skip(InfoGenreDto::setId)).setPostConverter(toDtoConverter());
//        mapper.createTypeMap(InfoGenreDto.class, Genre.class)
//                .addMappings(m -> m.skip(Genre::setId)).setPostConverter(toEntityConverter());
//    }
//
//
//    Converter<Genre, InfoGenreDto> toDtoConverter() {
//        return context -> {
//            Genre source = context.getSource();
//            InfoGenreDto destination = context.getDestination();
//            mapSpecificFields(source, destination);
//            return context.getDestination();
//        };
//    }
//
//    Converter<InfoGenreDto, Genre> toEntityConverter() {
//        return context -> {
//            InfoGenreDto source = context.getSource();
//            Genre destination = context.getDestination();
//            mapSpecificFields(source, destination);
//            return context.getDestination();
//        };
//    }
//
//    public void mapSpecificFields(Genre source, InfoGenreDto destination) {
//        destination.setId(getId(source));
//    }
//
//    private Long getId(Genre source) {
//        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getId();
//    }
//
//    void mapSpecificFields(InfoGenreDto source, Genre destination) {
////        destination.setId(genreRepository.findById(source.getId()));
////        destination.setMovies(genreRepository.findById(source.getMovies()).orElse(null));
//    }
//}