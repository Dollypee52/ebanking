package africa.semicolon.ebanking.exceptions;

public class WrongPasswordException extends RuntimeException{

    public WrongPasswordException(String message){
        super(message);
    }
}
