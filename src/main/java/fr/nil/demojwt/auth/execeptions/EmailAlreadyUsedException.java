package fr.nil.demojwt.auth.execeptions;

public class EmailAlreadyUsedException extends RuntimeException {

    public EmailAlreadyUsedException() {
        super("This email is already used.");
    }
}
