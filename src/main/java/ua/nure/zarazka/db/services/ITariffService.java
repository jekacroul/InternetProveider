package ua.nure.zarazka.db.services;

import ua.nure.zarazka.db.entity.Tariff;

import java.util.List;

/**
 * @author @author Evgeny Norkin
 */
public interface ITariffService {

    List<Tariff> findAll();

    List<Tariff> findAllById(long id);

    Tariff find(long id);

    Tariff find(String name);

    void save(Tariff tariff);

    void update(Tariff tariff);

    void remove(long id);
}
