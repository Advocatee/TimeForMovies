package film.springbootapplication.service.impl;

import film.springbootapplication.model.Genre;
import film.springbootapplication.repository.GenreRepository;
import film.springbootapplication.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public Optional<Genre> getById(Long id) {
        return genreRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        //TODO не удалять а помечать active = false и ставить дату в поле updated

    }

    @Override
    public Genre create(Genre movie) {
        return genreRepository.save(movie);
    }

    @Override
    public Genre update(Genre movie) {

        // TODO How?
        return null;
    }


}
