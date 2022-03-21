package africa.semicolon.phoneBook.data.models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@EqualsAndHashCode
//@Document("Contacts")


public class Contact {

    private String fullName;
////        @NonNull
//        private String firstName;
////        @NonNull
//        private String lastName;
//        private String middleName;
//        @NonNull
        private String mobileNumber;
        private String officeNumber;

//    @Id
//    private int id;

}
