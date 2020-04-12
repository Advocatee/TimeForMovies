package film.springbootapplication.controller;

import film.springbootapplication.dto.InfoGenreDto;
import film.springbootapplication.dto.UpdateGenreDto;
import film.springbootapplication.model.Genre;
import film.springbootapplication.service.GenreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GenreController extends BaseController<GenreService> {

    private final GenreService service;

    @Autowired
    public GenreController(GenreService service) {
        this.service = service;
    }

    @GetMapping
    public List<Genre> findGenres() {
        return service.getAll();
    }

    @GetMapping(value = "/genres/{id}")
    public InfoGenreDto findGenre(@PathVariable Long id) {

//        return genreService.getGenreById(id).orElseThrow(() -> new EntityNotFoundException("No Genre with such ID"));

        Optional<Genre> genre = service.getById(id);

        return getModelMapper().map(genre, InfoGenreDto.class);
    }

    @PostMapping("/genres")
    public Genre addGenre(@RequestBody UpdateGenreDto dto) {

        ModelMapper modelMapper = new ModelMapper();
        InfoGenreDto genreDto = modelMapper.map(dto, InfoGenreDto.class);

//        assert genreDto.getName().equals(dto.getName());
//        assert genreDto.getId().equals(dto.getDataSourceId());
//        assert genreDto.getMovies().equals(dto.getDataSource());
//
//
//        //TODO Add ModelMapper
//        Genre g = new Genre();
//        g.setDataSource(dto.getDataSource());
//        g.setDataSourceId(dto.getDataSourceId());
//        g.setName(dto.getName());

//        return service.create(g);
        return null;
    }

    @DeleteMapping(value = "/genres/{id}")
    public void removeGenre(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping(value = "/genres/{id}")
    public Genre updateGenre(@PathVariable Genre id) {
        return service.update(id);
    }
}
