package africa.semicolon.ebanking.utils;

import africa.semicolon.ebanking.data.model.BankUser;
import africa.semicolon.ebanking.dto.BankUserRequest.RegisterUserRequest;
import africa.semicolon.ebanking.dto.BankUserResponse.LoginUserResponse;
import africa.semicolon.ebanking.dto.BankUserResponse.RegisterUserResponse;

import java.util.Optional;

public class Mapper {
    public static void map(RegisterUserRequest request, BankUser user) {
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAddress(request.getAddress());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setEmail(request.getEmail());
        user.setOccupation(request.getOccupation());
        user.setPassword(request.getPassword());
    }
    public static void map(BankUser savedUser, RegisterUserResponse userResponse) {
        userResponse.setMessage("Welcome on board "+ savedUser.getFirstName().toUpperCase() + ". Your account creation was successful.");
        userResponse.setAccountNumber("Your account number is " + savedUser.getAccountNumber());

    }

    public static void map(Optional<BankUser> savedUser, LoginUserResponse loginUserResponse) {
        loginUserResponse.setFirstName(savedUser.get().getFirstName());
        loginUserResponse.setLastName(savedUser.get().getLastName());
        loginUserResponse.setAccountNumber(savedUser.get().getAccountNumber());
        loginUserResponse.setBalance(savedUser.get().getBalance());
    }
}

