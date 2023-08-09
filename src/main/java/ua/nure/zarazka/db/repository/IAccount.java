package ua.nure.zarazka.db.repository;

import ua.nure.zarazka.db.entity.Account;

/**
 * @author @author Evgeny Norkin
 */
public interface IAccount extends IEntity<Account> {
    long newNumberContract();
}
