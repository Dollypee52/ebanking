package africa.semicolon.ebanking.exceptions;

public class InvalidAmountException extends RuntimeException{

    public InvalidAmountException(String message){
        super(message);
    }
}
