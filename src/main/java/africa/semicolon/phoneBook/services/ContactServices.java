package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.dtos.requests.SaveContactRequest;
import africa.semicolon.phoneBook.data.dtos.responses.FindContactResponse;
import africa.semicolon.phoneBook.data.dtos.responses.SaveContactResponse;
import africa.semicolon.phoneBook.data.repositories.ContactRepository;
import africa.semicolon.phoneBook.exceptions.ContactDoesNotExistException;
import africa.semicolon.phoneBook.exceptions.ContactExistException;

public interface ContactServices {

    SaveContactResponse saveContact(SaveContactRequest newContact) throws ContactExistException;

    ContactRepository getRepository();

    FindContactResponse findByMobile(String contact) throws ContactDoesNotExistException;



}
