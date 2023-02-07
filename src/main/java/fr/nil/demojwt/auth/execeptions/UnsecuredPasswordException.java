package fr.nil.demojwt.auth.execeptions;

public class UnsecuredPasswordException extends RuntimeException{
    public UnsecuredPasswordException() {
        super("Password is too weak, requires at least 12 characters.");
    }
}
