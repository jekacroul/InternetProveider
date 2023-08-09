package by.nure.jekacroul.db.services;

import by.nure.jekacroul.db.entity.Tariff;
import by.nure.jekacroul.db.entity.User;

import java.util.List;

/**
 * @author @author Evgeny Norkin
 */
public interface IUserService {

    List<User> findAll();

    User find(long id);

    void save(User user);

    void update(User user);

    void remove(int id);

    User findByLogin(String login);

    List<Tariff> findUserTariffs(User user);

    void saveLinksUsersHasTariffs(User user, String[] tariffsId);

    void removeLinksUsersHasTariffs(User user);
}
