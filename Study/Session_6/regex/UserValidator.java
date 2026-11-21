package Study.Session_6.regex;

public class UserValidator {
    public static boolean isValidUsername(String username) {
        return username.matches("[a-z0-9_-]{3,15}");
    }

    public static boolean isValidPassword(String password) {
        return password.matches("[a-zA-Z]{11,}");
    }

}
