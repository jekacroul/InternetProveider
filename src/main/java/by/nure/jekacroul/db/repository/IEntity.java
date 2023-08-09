package by.nure.jekacroul.db.repository;

import by.nure.jekacroul.db.entity.Entity;

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
