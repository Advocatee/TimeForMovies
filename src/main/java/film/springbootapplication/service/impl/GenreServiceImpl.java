package film.springbootapplication.service.impl;

import film.springbootapplication.model.Genre;
import film.springbootapplication.repository.GenreRepository;
import film.springbootapplication.service.GenreService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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
    public Long delete(Long id) {
        Genre activeGenre = genreRepository.findByIdAndActive(id, true);
        activeGenre.setActive(false);
        genreRepository.save(activeGenre);
        return activeGenre.getId();
    }


    @Override
    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre update(Genre genre) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(genre);
        return genre;
    }


    @Override
    public Genre findByName(String genreName) {
//        return genreRepository.findByName(genreName);
        return null;
    }
}
