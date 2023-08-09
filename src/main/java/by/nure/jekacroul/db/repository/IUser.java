package by.nure.jekacroul.db.repository;

import by.nure.jekacroul.db.entity.Tariff;
import by.nure.jekacroul.db.entity.User;

import java.util.List;

/**
 * @author @author Evgeny Norkin
 */
public interface IUser extends IEntity<User> {

    User getByLogin(String login);

    List<Tariff> getTariffs(User user);

    void addLinksUsersHasTariffs(User user, String[] tariffsId);

    void deleteLinksUsersHasTariffs(User user);
}
