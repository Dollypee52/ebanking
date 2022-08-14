package africa.semicolon.ebanking.exceptions;

public class EmailNotFoundException extends RuntimeException{

    public EmailNotFoundException(String message){
        super(message);
    }
}
