package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.models.Contact;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static final List<Contact> contacts = new ArrayList<>();

    private DataBase(){
    }

    public static List<Contact> getInstance(){
        return contacts;
    }
}
