package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.dtos.requests.SaveContactRequest;
import africa.semicolon.phoneBook.data.dtos.responses.FindContactResponse;
import africa.semicolon.phoneBook.data.dtos.responses.SaveContactResponse;
import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.data.repositories.ContactRepository;
import africa.semicolon.phoneBook.data.repositories.ContactRepositoryImpl;
import africa.semicolon.phoneBook.exceptions.ContactDoesNotExistException;
import africa.semicolon.phoneBook.exceptions.ContactExistException;

public class ContactServicesImpl implements ContactServices{

    private ContactRepository contactRepository = new ContactRepositoryImpl();

    @Override
    public SaveContactResponse saveContact(SaveContactRequest newContact) throws ContactExistException {

    if(contactExists(newContact.getMobileNumber())) throw new ContactExistException("The mobile number exists");
//    newContact.setMobileNumber(newContact.getMobileNumber());


    String fullName = newContact.getFirstName() + " " + newContact.getMiddleName() + " " + newContact.getLastName();
    String mobileNo = newContact.getMobileNumber();
    String officeNo = newContact.getOfficeNumber();

    Contact contact1 = new Contact(fullName,mobileNo,officeNo);
//    Contact contact1 = new Contact(newContact.getFirstName(), newContact.getLastName(), newContact.getMiddleName(), newContact.getMobileNumber(), newContact.getOfficeNumber());

    Contact saveContact = contactRepository.createContact(contact1);

    SaveContactResponse saveContactResponse = new SaveContactResponse();

    saveContactResponse.setFullName(saveContact.getFullName());
    saveContactResponse.setMobileNumber(saveContact.getMobileNumber());
    saveContactResponse.setOfficeNumber(saveContact.getOfficeNumber());

        return saveContactResponse;
    }

    private boolean contactExists(String mobileNumber) {
        Contact contact = contactRepository.findByMobileNo(mobileNumber);
        if(contact != null){
            return true;
        }
        return false;
    }

    @Override
    public ContactRepository getRepository() {
        return contactRepository;
    }

    @Override
    public FindContactResponse findByMobile(String contact) throws ContactDoesNotExistException {
        Contact contact1 = contactRepository.findByMobileNo(contact);

        if (contact1 == null) throw new ContactDoesNotExistException(contact + " does not exist");
        FindContactResponse findContactResponse = new FindContactResponse();
        findContactResponse.setMobileNo(contact1.getMobileNumber());
        findContactResponse.setFullName(contact1.getFullName());

        return findContactResponse;
    }
}
