package Lab.Lab_5;

public class PasswordValidator {
    public static boolean validatePassword(String password) {
        if (password.length() < 11) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                return false;
            }
        }

        return true;
    }
}
