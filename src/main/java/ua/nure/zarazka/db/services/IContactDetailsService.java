package ua.nure.zarazka.db.services;

import ua.nure.zarazka.db.entity.ContactDetails;

import java.util.List;

/**
 * @author @author Evgeny Norkin
 */
public interface IContactDetailsService {

    List<ContactDetails> findAll();

    ContactDetails find(long id);

    void save(ContactDetails account);

    void update(ContactDetails account);

    void remove(int id);
}
