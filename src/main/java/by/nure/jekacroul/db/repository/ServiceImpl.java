package by.nure.jekacroul.db.repository;

import by.nure.jekacroul.db.entity.PackageServices;
import by.nure.jekacroul.db.builders.QueryBuilder;
import by.nure.jekacroul.db.builders.ServiceQueryBuilder;

import java.util.List;

/**
 * @author @author Evgeny Norkin
 */
public class ServiceImpl implements IService {
    private static final String GET_ALL = "SELECT * FROM provider.services";
    private static final String GET_BY_ID = "SELECT id, name, description FROM provider.services WHERE id = ?";
    private static final String CREATE = "INSERT INTO provider.services (name, description) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE provider.services SET name = ?, description = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM provider.services WHERE id = ?";

    private DBManager instance = DBManager.getInstance();

    @Override
    public List<PackageServices> getAll() {
        QueryBuilder queryBuilder = new ServiceQueryBuilder();
        return queryBuilder.executeAndReturnList(instance, GET_ALL);
    }

    @Override
    public PackageServices getById(long id) {
        QueryBuilder queryBuilder = new ServiceQueryBuilder();
        return (PackageServices) queryBuilder.executeAndReturn(instance, GET_BY_ID, id);
    }

    @Override
    public void create(PackageServices packageServices) {
        QueryBuilder queryBuilder = new ServiceQueryBuilder();
        queryBuilder.execute(instance, CREATE, packageServices.getName(), packageServices.getDescription());
    }

    @Override
    public void update(PackageServices packageServices) {

    }

    @Override
    public void delete(long id) {
        QueryBuilder queryBuilder = new ServiceQueryBuilder();
        queryBuilder.execute(instance, DELETE, id);
    }
}
