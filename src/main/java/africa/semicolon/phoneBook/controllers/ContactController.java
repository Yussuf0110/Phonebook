package africa.semicolon.phoneBook.controllers;

import africa.semicolon.phoneBook.data.dtos.requests.SaveContactRequest;
import africa.semicolon.phoneBook.data.dtos.responses.FindContactResponse;
import africa.semicolon.phoneBook.data.dtos.responses.SaveContactResponse;
import africa.semicolon.phoneBook.exceptions.ContactDoesNotExistException;
import africa.semicolon.phoneBook.exceptions.ContactExistException;
import africa.semicolon.phoneBook.services.ContactServices;
import africa.semicolon.phoneBook.services.ContactServicesImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")

public class ContactController {
    private ContactServices contactServices = new ContactServicesImpl();

    @PostMapping("/saveContact")
    public SaveContactResponse createContact(SaveContactRequest createRequest) throws ContactExistException {
        return contactServices.saveContact(createRequest);
    }

    @GetMapping("/{mobileNumber}")
    public FindContactResponse findContactByMobile(String mobileNumber) throws ContactDoesNotExistException {
        return contactServices.findByMobile(mobileNumber);
    }
}
