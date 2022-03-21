package africa.semicolon.phoneBook.exceptions;

public class ContactDoesNotExistException extends ContactException{
    public ContactDoesNotExistException(String message){
        super(message);
    }
}
