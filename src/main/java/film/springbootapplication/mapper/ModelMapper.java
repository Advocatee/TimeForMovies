//package film.springbootapplication.mapper;
//
//import film.springbootapplication.dto.InfoGenreDto;
//import film.springbootapplication.dto.UpdateMovieDto;
//import film.springbootapplication.model.Genre;
//import film.springbootapplication.model.Movie;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Objects;
//
//@Component
//public class ModelMapper {
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public Movie toEntity(UpdateMovieDto dto) {
//        return Objects.isNull(dto) ? null : modelMapper.map(dto, Movie.class);
//    }
//
//    public UpdateMovieDto toDto(UpdateMovieDto entity) {
//        return Objects.isNull(entity) ? null : modelMapper.map(entity, UpdateMovieDto.class);
//    }
//
////    public ModelMapper createTypeMap(Class<Genre> genreClass, Class<InfoGenreDto> infoGenreDtoClass) {
////        return null;
////    }
//}
