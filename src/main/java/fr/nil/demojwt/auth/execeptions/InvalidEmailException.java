package fr.nil.demojwt.auth.execeptions;

public class InvalidEmailException extends RuntimeException {

    public InvalidEmailException() {
        super("The provided email is incorrect.");

    }
}
