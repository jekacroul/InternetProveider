package by.nure.jekacroul.db.repository;

import by.nure.jekacroul.db.entity.Account;

/**
 * @author @author Evgeny Norkin
 */
public interface IAccount extends IEntity<Account> {
    long newNumberContract();
}
