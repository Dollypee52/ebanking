package africa.semicolon.ebanking.dto.BankUserResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DepositResponse {

    private String message;
    private int balance;
}
