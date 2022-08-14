package africa.semicolon.ebanking.dto.BankUserResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginUserResponse {

    private String message;
    private String firstName;
    private String lastName;
    private String accountNumber;
    private int balance;
}
