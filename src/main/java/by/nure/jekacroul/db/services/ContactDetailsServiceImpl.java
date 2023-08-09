package by.nure.jekacroul.db.services;

import by.nure.jekacroul.db.repository.ContactDetailsImpl;
import by.nure.jekacroul.db.repository.IContactDetails;
import by.nure.jekacroul.db.entity.ContactDetails;

import java.util.List;

/**
 * @author @author Evgeny Norkin
 */
public class ContactDetailsServiceImpl implements IContactDetailsService {
    private final IContactDetails repo = new ContactDetailsImpl();

    @Override
    public List<ContactDetails> findAll() {
        return this.repo.getAll();
    }

    @Override
    public ContactDetails find(long id) {
        return this.repo.getById(id);
    }

    @Override
    public void save(ContactDetails account) {
        this.repo.create(account);
    }

    @Override
    public void update(ContactDetails account) {
        this.repo.update(account);
    }

    @Override
    public void remove(int id) {
        this.repo.delete(id);
    }
}
