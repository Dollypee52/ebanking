package africa.semicolon.ebanking.service;

import africa.semicolon.ebanking.dto.BankUserRequest.*;
import africa.semicolon.ebanking.dto.BankUserResponse.*;

public interface BankUserService {

    LoginUserResponse loginUserRequest(LoginUserRequest loginUserRequest);
    RegisterUserResponse createAccount(RegisterUserRequest request);
    DepositResponse deposit(DepositRequest depositRequest);
    TransferResponse transfer(TransferRequest request);
    CheckBalanceResponse checkBalance(CheckBalanceRequest checkBalanceRequest);
    WithdrawalResponse withdrawal(WithdrawalRequest withdrawalRequest);
}
