package africa.semicolon.ebanking.dto.BankUserResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawalResponse {

    private String message;
    private int balance;

    public void setAccountBalance(int balance) {
    }
}
