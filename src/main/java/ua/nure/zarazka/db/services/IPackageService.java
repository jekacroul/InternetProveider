package ua.nure.zarazka.db.services;

import ua.nure.zarazka.db.entity.PackageServices;

import java.util.List;

/**
 * @author @author Evgeny Norkin
 */
public interface IPackageService {

    List<PackageServices> findAll();

    PackageServices find(long id);

    void save(PackageServices service);

    void update(PackageServices service);

    void remove(long id);
}
