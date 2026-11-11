package Lab.Lab_6;

public interface ValidatePhone {
    static boolean validatePhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        if (phoneNumber == null || phoneNumber.length() != 10) {
            throw new WrongPhoneNumberException("Telefonniat nomer trqbva da ima 10 tsifri.");
        }

        for (int i = 0; i < phoneNumber.length(); i++) {
            char symbol = phoneNumber.charAt(i);
            if (symbol < '0' || symbol > '9') {
                throw new WrongPhoneNumberException("Telefonniat nomer trqbva da sudurja samo tsifri.");
            }
        }

        return true;
    }
}
