package africa.semicolon.ebanking.service;

import africa.semicolon.ebanking.data.model.BankUser;
import africa.semicolon.ebanking.data.repository.BankUserRepository;
import africa.semicolon.ebanking.dto.BankUserRequest.*;
import africa.semicolon.ebanking.dto.BankUserResponse.*;
import africa.semicolon.ebanking.exceptions.*;

import africa.semicolon.ebanking.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BankUserServiceImpl implements BankUserService {

    @Autowired
    private BankUserRepository bankUserRepository;
    private  TransferRequest transferRequest;

    @Override
    public LoginUserResponse loginUserRequest(LoginUserRequest loginUserRequest) {
        Optional<BankUser> savedUser = bankUserRepository.findByEmail(loginUserRequest.getEmail());
        if (savedUser.isPresent()){
            if (savedUser.get().getPassword().equals(loginUserRequest.getPassword())){
                LoginUserResponse loginUserResponse = new LoginUserResponse();
               loginUserResponse.setMessage("Welcome back " + savedUser.get().getFirstName());
                Mapper.map(savedUser, loginUserResponse);
               return loginUserResponse;
            }
       }
        throw new EmailNotFoundException("Email not found");

    }

    @Override
    public RegisterUserResponse createAccount(RegisterUserRequest request) {
        if (bankUserRepository.existsByEmail(request.getEmail())) throw new UserAlreadyExistException("Email already exist");
       BankUser user = new BankUser();
        Mapper.map(request, user);
        String accountNumber = String.valueOf(UUID.randomUUID().getMostSignificantBits());
        accountNumber = accountNumber.substring(1, 10);
        user.setAccountNumber(accountNumber);

        BankUser savedUser = bankUserRepository.save(user);
       RegisterUserResponse userResponse = new RegisterUserResponse();
        Mapper.map(savedUser, userResponse);

        return userResponse;
    }


    @Override
    public DepositResponse deposit(DepositRequest depositRequest) {
        Optional<BankUser> savedUser = bankUserRepository.findByAccountNumber(depositRequest.getAccountNumber());
        if (savedUser.isPresent()){
            if (depositRequest.getAmount() > 0){
                savedUser.get().setBalance(savedUser.get().getBalance() + depositRequest.getAmount());
                DepositResponse depositResponse = new DepositResponse();
                depositResponse.setMessage("The deposit of " + depositRequest.getAmount() + " to " +
                        savedUser.get().getFirstName() + " " + savedUser.get().getLastName() + " was successful");
                depositResponse.setBalance(savedUser.get().getBalance());

                bankUserRepository.save(savedUser.get());

                return depositResponse;
            }else{
                throw new IllegalArgumentException("Invalid amount");
            }
        }
        throw new IllegalArgumentException("Invalid Account");
    }


    @Override
    public TransferResponse transfer(TransferRequest request) {
        Optional<BankUser>sender = bankUserRepository.findByAccountNumber(transferRequest.getSenderAccountNumber());
        if (sender.isPresent()){
            if (sender.get().getPassword().equals(transferRequest.getPassword())){
                Optional<BankUser>receiver = bankUserRepository.findByAccountNumber(transferRequest.getReceiverAccountNumber());
                if (receiver.isPresent()){
                    if (transferRequest.getAmount() > 0 && sender.get().getBalance() >= transferRequest.getAmount()){
                        sender.get().setBalance(sender.get().getBalance() - transferRequest.getAmount());
                        receiver.get().setBalance(receiver.get().getBalance() + transferRequest.getAmount());
                        TransferResponse transferResponse = new TransferResponse();
                        transferResponse.setMessage("You have successfully transferred " + transferRequest.getAmount()
                                + " to " + receiver.get().getFirstName() + "." + " Your remaining balance is "
                                + sender.get().getBalance());
                        bankUserRepository.save(sender.get());
                        bankUserRepository.save(receiver.get());
                        return transferResponse;
                    }else{
                        throw new InvalidAmountException("Invalid amount");
                    }
                }else{
                    throw  new AccountNotFoundException("Receiver's account not found");
                }
            }else{
                throw new WrongPasswordException("Incorrect password");
            }
        }else {
            throw new AccountNotFoundException("Account not found");
        }
    }


    @Override
    public CheckBalanceResponse checkBalance(CheckBalanceRequest checkBalanceRequest) {
        Optional<BankUser>savedUser = bankUserRepository.findByAccountNumber(checkBalanceRequest.getAccountNumber());
        if (savedUser.isPresent()){
            if (savedUser.get().getPassword().equals(checkBalanceRequest.getPassword())){
                CheckBalanceResponse checkBalanceResponse = new CheckBalanceResponse();
                checkBalanceResponse.setMessage(savedUser.get().getFirstName().toUpperCase() +", your remaining balance is " + savedUser.get().getBalance());
                return checkBalanceResponse;
            }else{
                throw new WrongPasswordException("Password incorrect");
            }
        }else{
            throw new AccountNotFoundException("Account not Found");
        }
    }



    @Override
    public WithdrawalResponse withdrawal(WithdrawalRequest withdrawalRequest) {
        Optional<BankUser>savedUser = bankUserRepository.findByAccountNumber(withdrawalRequest.getAccountNumber());
        if (savedUser.isPresent()){
            if (savedUser.get().getPassword().equals(withdrawalRequest.getPassword())){
                if (savedUser.get().getBalance() >= withdrawalRequest.getAmount() && withdrawalRequest.getAmount() > 0){
                    savedUser.get().setBalance(savedUser.get().getBalance() - withdrawalRequest.getAmount());
                    WithdrawalResponse withdrawalResponse = new WithdrawalResponse();
                    withdrawalResponse.setMessage("Txn : Debit" + "\n" + "amount : " + withdrawalRequest.getAmount());
                    withdrawalResponse.setAccountBalance(savedUser.get().getBalance());
                    bankUserRepository.save(savedUser.get());
                    return withdrawalResponse;
                }else{
                    throw new InvalidAmountException("Invalid amount");
                }
            }else {
                throw new WrongPasswordException("Password incorrect");
            }
        }else {
            throw new AccountNotFoundException("Account not Found");
        }
    }
    }

