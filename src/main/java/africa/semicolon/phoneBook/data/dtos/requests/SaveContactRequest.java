package africa.semicolon.phoneBook.data.dtos.requests;


import lombok.Data;
import lombok.NonNull;

@Data
public class SaveContactRequest {
//    @NonNull
    private String firstName;
//    @NonNull
    private String lastName;
    private String middleName;
//    @NonNull
    private String mobileNumber;
    private String officeNumber;



}
