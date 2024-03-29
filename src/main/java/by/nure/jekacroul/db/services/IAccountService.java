package by.nure.jekacroul.db.services;

import by.nure.jekacroul.db.entity.Account;

import java.util.List;

/**
 * @author @author Evgeny Norkin
 */
public interface IAccountService {

    List<Account> findAll();

    Account find(long id);

    void save(Account account);

    void update(Account account);

    void remove(long id);

    long getNumberContract();
}
