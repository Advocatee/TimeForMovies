package film.springbootapplication.service;

import film.springbootapplication.model.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity> {
    List<T> getAll();

    Optional<T> getById(Long id);

    Long delete(Long id);

    T create(T movie);

    T update(T movie);
}
