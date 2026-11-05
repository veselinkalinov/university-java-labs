package Lab.Lab_5;

public class UsernameValidator {
    public static boolean validateUsername(String username) {
        if (username.length() < 3 || username.length() > 15) {
            return false;
        }

        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);

            if (!((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '_' || c == '-')) {
                return false;
            }
        }

        return true;
    }
}
