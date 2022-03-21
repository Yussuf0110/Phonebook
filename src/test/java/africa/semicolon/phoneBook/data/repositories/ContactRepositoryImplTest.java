package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.models.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {
    private Contact contact;

    private ContactRepository repository;

    @BeforeEach
    void setUp(){
        contact = new Contact();
//        contact.setFirstName("Ti");
//        contact.setLastName("Li");
        contact.setMobileNumber("00900");
        contact.setOfficeNumber("6766");
//        contact.setMiddleName("yer");
        repository = new ContactRepositoryImpl();
    }

    @Test
    void testSaveContact(){
        Contact returnedContact = repository.createContact(contact);

//        assertEquals(1, returnedContact.getId());
        assertEquals(1,repository.count());
    }


    @Test
    void findByMobileNoTest(){
        Contact contact1 = new Contact();
        contact1.setMobileNumber("08122");
//        contact1.setFirstName("Bad");
//        contact1.setLastName("Boy");


        Contact firstContact = repository.createContact(contact);
        Contact savedAnotherContact = repository.createContact(contact1);

        Contact contactFound = repository.findByMobileNo("00900");

        assertEquals(2,repository.count());
        assertEquals(firstContact,contactFound);
    }




    @Test
    void findAllContactTest(){
        saveThreeContact();

        List<Contact> findALlContact = repository.findAll();

        assertEquals(3,findALlContact.size());
    }

    @Test
    void contactCanBeDeletedByMobileNo(){
        Contact contact1 = new Contact();
        contact1.setMobileNumber("08122");
//        contact1.setFirstName("Bad");
//        contact1.setLastName("Boy");

        Contact contact2 = new Contact();
        contact2.setMobileNumber("03522");
//        contact2.setFirstName("Black");
//        contact2.setLastName("Boy");

        Contact contact3 = repository.createContact(contact);
        Contact contactSave = repository.createContact(contact1);
        Contact contactSaved = repository.createContact(contact2);

        repository.delete("03522");

        assertEquals(2,repository.count());
    }

    @Test
    void contactCanBeDeletedByContact(){
        Contact contact1 = new Contact();
        contact1.setMobileNumber("08122");
//        contact1.setFirstName("Bad");
//        contact1.setLastName("Boy");

        Contact contact2 = new Contact();
        contact2.setMobileNumber("03522");
//        contact2.setFirstName("Black");
//        contact2.setLastName("Boy");

        Contact contact3 = repository.createContact(contact);
        Contact contactSave = repository.createContact(contact1);
        Contact contactSaved = repository.createContact(contact2);

        repository.delete(contact2);

        assertEquals(2,repository.count());
    }



    private void saveThreeContact() {
        Contact contact1 = new Contact();
        contact1.setMobileNumber("08122");
//        contact1.setFirstName("Bad");
//        contact1.setLastName("Boy");

        Contact contact2 = new Contact();
        contact2.setMobileNumber("03522");
//        contact2.setFirstName("Black");
//        contact2.setLastName("Boy");

        Contact contact3 = repository.createContact(contact);
        Contact contactSave = repository.createContact(contact1);
        Contact contactSaved = repository.createContact(contact2);
    }
}



