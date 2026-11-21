package Study.Session_6.regex;

public class Main {
    public static void main(String[] args) {

        // Username validation
        System.out.println("=== Username Validation ===");

        String[] usernames = {
                "abc", // Valid: 3 characters
                "user_123", // Valid: letters, digits, underscore
                "user-name", // Valid: hyphen
                "abcdefghijklmno", // Valid: 15 characters
                "ab", // Invalid: too short
                "abcdefghijklmnop", // Invalid: too long
                "User123", // Invalid: uppercase letter
                "user@123", // Invalid: special character
                "user name" // Invalid: space
        };

        for (String username : usernames) {
            System.out.println(username + " -> " +
                    UserValidator.isValidUsername(username));
        }

        // Password validation
        System.out.println("\n=== Password Validation ===");

        String[] passwords = {
                "abcdefghijk", // Valid: 11 lowercase letters
                "ABCDEFGHIJK", // Valid: 11 uppercase letters
                "AbCdEfGhIjK", // Valid: mixed case
                "abcdefghijkl", // Valid: 12 letters
                "abcdefghij", // Invalid: only 10 characters
                "abcdefghijk1", // Invalid: digit
                "abcdefghijk!", // Invalid: special character
                "abcdef ghijk" // Invalid: space
        };

        for (String password : passwords) {
            System.out.println(password + " -> " +
                    UserValidator.isValidPassword(password));
        }
    }
}
