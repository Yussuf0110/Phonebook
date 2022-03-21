package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.dtos.requests.SaveContactRequest;
import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.exceptions.ContactException;

import java.util.List;

public interface ContactRepository {

    Contact createContact(Contact contact);
    Contact findByMobileNo(String mobileNo);
    List<Contact> findAll();
    void delete(Contact contact);
    void delete(String mobileNo);

    int count();



}
