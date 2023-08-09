package by.nure.jekacroul.db.services;

import by.nure.jekacroul.db.repository.IService;
import by.nure.jekacroul.db.repository.ServiceImpl;
import by.nure.jekacroul.db.entity.PackageServices;

import java.util.List;

/**
 * @author @author Evgeny Norkin
 */
public class PackageServiceImpl implements IPackageService {
    private final IService repo = new ServiceImpl();

    @Override
    public List<PackageServices> findAll() {
        return this.repo.getAll();
    }

    @Override
    public PackageServices find(long id) {
        return this.repo.getById(id);
    }

    @Override
    public void save(PackageServices service) {
        this.repo.create(service);
    }

    @Override
    public void update(PackageServices service) {
        this.repo.update(service);
    }

    @Override
    public void remove(long id) {
        this.repo.delete(id);
    }
}
