package africa.semicolon.ebanking.dto.BankUserRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CheckBalanceRequest {

    private String password;
    private String accountNumber;


}
