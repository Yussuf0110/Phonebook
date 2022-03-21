package africa.semicolon.phoneBook.exceptions;

public class ContactException extends Exception{
    public ContactException() {
    }

    public ContactException(String message) {
        super(message);
    }

    public ContactException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContactException(Throwable cause) {
        super(cause);
    }
}
