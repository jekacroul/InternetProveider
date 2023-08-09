package ua.nure.zarazka.db.repository;

import ua.nure.zarazka.db.entity.Tariff;

import java.util.List;

/**
 * @author @author Evgeny Norkin
 */
public interface ITariff extends IEntity<Tariff> {

    List<Tariff> getAllByServiceId(long id);

    Tariff getByName(String name);
}
