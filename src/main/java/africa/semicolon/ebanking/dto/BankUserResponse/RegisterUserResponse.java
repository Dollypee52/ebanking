package africa.semicolon.ebanking.dto.BankUserResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegisterUserResponse {

    private String message;
    private String accountNumber;
}
