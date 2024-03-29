package by.nure.jekacroul.db.services;

import by.nure.jekacroul.db.repository.ITariff;
import by.nure.jekacroul.db.repository.TariffImpl;
import by.nure.jekacroul.db.entity.Tariff;

import java.util.List;

/**
 * @author @author Evgeny Norkin
 */
public class TariffServiceImpl implements ITariffService {
    private final ITariff repo = new TariffImpl();

    @Override
    public List<Tariff> findAll() {
        return this.repo.getAll();
    }

    @Override
    public Tariff find(long id) {
        return this.repo.getById(id);
    }

    @Override
    public Tariff find(String name) {
        return this.repo.getByName(name);
    }

    @Override
    public List<Tariff> findAllById(long id) {
        return this.repo.getAllByServiceId(id);
    }

    @Override
    public void save(Tariff tariff) {
        this.repo.create(tariff);
    }

    @Override
    public void update(Tariff tariff) {
        this.repo.update(tariff);
    }

    @Override
    public void remove(long id) {
        this.repo.delete(id);
    }
}
