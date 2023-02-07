package fr.nil.demojwt.auth.execeptions;

import java.util.Arrays;
import java.util.List;

public class InvalidUsernameException extends RuntimeException{


   final static String[] blacklistedUsernames = new String[] { "admin", "administrator", "root", "sysadmin", "test", "guest", "demo", "support", "help", "api", "guestuser", "anonymous", "default","sql","mysql","user","username" };
    public static final List<String> BLACKLISTED_USERNAME_LIST = Arrays.asList(blacklistedUsernames);

    public InvalidUsernameException(String providedUsername) {
        super("Provided username is invalid. (Username : " + providedUsername + ").");
    }
}
