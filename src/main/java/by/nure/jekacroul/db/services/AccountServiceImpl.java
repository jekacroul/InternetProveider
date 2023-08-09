package by.nure.jekacroul.db.services;

import by.nure.jekacroul.db.repository.AccountImpl;
import by.nure.jekacroul.db.repository.IAccount;
import by.nure.jekacroul.db.entity.Account;

import java.util.List;

/**
 * @author @author Evgeny Norkin
 */
public class AccountServiceImpl implements IAccountService {
    private final IAccount repo = new AccountImpl();

    @Override
    public List<Account> findAll() {
        return this.repo.getAll();
    }

    @Override
    public Account find(long id) {
        return this.repo.getById(id);
    }

    @Override
    public void save(Account account) {
        this.repo.create(account);
    }

    @Override
    public void update(Account account) {
        this.repo.update(account);
    }

    @Override
    public void remove(long id) {
        this.repo.delete(id);
    }

    @Override
    public long getNumberContract() {
        return repo.newNumberContract();
    }
}
