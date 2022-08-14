package africa.semicolon.ebanking.dto.BankUserRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TransferRequest {

    private String senderAccountNumber;
    private String password;
    private String receiverAccountNumber;
    private int amount;
}
