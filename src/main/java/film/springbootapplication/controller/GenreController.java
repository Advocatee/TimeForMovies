package film.springbootapplication.controller;

import film.springbootapplication.model.Genre;
import film.springbootapplication.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping( value = "/Genre")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping()
    public List<Genre> movieList() {

        return genreService.getAllGenres();

    }


}
