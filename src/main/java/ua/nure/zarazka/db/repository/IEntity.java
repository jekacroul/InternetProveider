package ua.nure.zarazka.db.repository;

import ua.nure.zarazka.db.entity.Entity;

import java.util.List;

/**
 * @author @author Evgeny Norkin
 */
public interface IEntity<T extends Entity> {
    List<T> getAll();

    T getById(long id);

    void create(T t);

    void update(T t);

    void delete(long id);
}
