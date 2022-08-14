package africa.semicolon.ebanking.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Accounts")

public class Account {
    @Id
    private  String ACCOUNTNUMBER;
    private  String fullName;
    private int balance;
    private String pin;

}
