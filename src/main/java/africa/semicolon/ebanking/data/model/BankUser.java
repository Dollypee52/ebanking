package africa.semicolon.ebanking.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("BankUsers")
public class BankUser {
    @Id
    private  String id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    private String address;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String accountNumber;
    private String password;
    private int balance;
    @NonNull
    private String occupation;
    private LocalDateTime dateRegistered;

}
