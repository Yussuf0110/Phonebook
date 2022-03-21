package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.dtos.requests.SaveContactRequest;
import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.exceptions.ContactException;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository{

    private List<Contact> contactList = new ArrayList<>();
//    private int id = 0;



    @Override
    public Contact createContact(Contact contact) {
//        int id = generateId();
//        contact.setId(id);
        contactList.add(contact);
        return contact;

    }

    @Override
    public Contact findByMobileNo(String mobileNo) {
        for (Contact aContact: contactList){
            if (aContact.getMobileNumber() == mobileNo){
                return aContact;
            }
        }
        return null;
    }
//
//    private int generateId() {
//        return ++id;
//    }

    @Override
    public List<Contact> findAll() {
        return contactList;
    }

    @Override
    public void delete(Contact contact) {
    contactList.remove(contact);
    }

    @Override
    public void delete(String mobileNo) {
    Contact otuns = findByMobileNo(mobileNo);
        delete(otuns);
    }

    @Override
    public int count() {
        return contactList.size();
    }





    //    Simpleton Method
//    @Override
//    public Contact createContact(Contact contact) {
//        DataBase.getInstance().add(contact);
//        return contact;
//    }



    //    private void validateContactRequest(SaveContactRequest request) throws ContactException {
//        if (request.getFirstName().isBlank()|| request.getFirstName().isEmpty()){
//            throw new ContactException("First name cannot be empty");
//        }
//        if (request.getLastName().isBlank()|| request.getLastName().isEmpty()){
//            throw new ContactException("Last name cannot be empty");
//        }
//        if (request.getMobileNumber().isBlank()|| request.getMobileNumber().isEmpty()){
//            throw new ContactException("Mobile number cannot be empty");
//        }
//    }
}
