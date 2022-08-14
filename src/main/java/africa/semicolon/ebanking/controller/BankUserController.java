package africa.semicolon.ebanking.controller;

import africa.semicolon.ebanking.dto.BankUserRequest.*;
import africa.semicolon.ebanking.dto.BankUserResponse.*;
import africa.semicolon.ebanking.service.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bankUsers/")
public class BankUserController {
    @Autowired
    private BankUserService bankUserService;

    @PostMapping("registration")
    public RegisterUserResponse register (@RequestBody RegisterUserRequest request) {
        return bankUserService.createAccount(request);
    }
    @PostMapping("/login")
    public LoginUserResponse loginRequest(@RequestBody LoginUserRequest loginUserRequest){
       return bankUserService.loginUserRequest(loginUserRequest);
    }
    @PostMapping("/deposit")
    public DepositResponse deposit(@RequestBody DepositRequest depositRequest){
        return bankUserService.deposit(depositRequest);
    }
    @PostMapping("/withdrawal")
    public WithdrawalResponse withdrawal(@RequestBody WithdrawalRequest withdrawalRequest){
        return bankUserService.withdrawal(withdrawalRequest);
    }
    @PostMapping("/balance")
    public CheckBalanceResponse checkBalance(@RequestBody CheckBalanceRequest checkBalanceRequest){
        return bankUserService.checkBalance(checkBalanceRequest);
    }
    @PostMapping("/transfer")

    public TransferResponse transfer(@RequestBody TransferRequest transferRequest){
      return bankUserService.transfer(transferRequest);
    }
}
