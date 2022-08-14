package africa.semicolon.ebanking.dto.BankUserRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawalRequest {

    private String accountNumber;
    private int amount;
    private String password;
}
