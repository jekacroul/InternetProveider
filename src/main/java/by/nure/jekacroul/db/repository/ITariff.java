package by.nure.jekacroul.db.repository;

import by.nure.jekacroul.db.entity.Tariff;

import java.util.List;

/**
 * @author @author Evgeny Norkin
 */
public interface ITariff extends IEntity<Tariff> {

    List<Tariff> getAllByServiceId(long id);

    Tariff getByName(String name);
}
