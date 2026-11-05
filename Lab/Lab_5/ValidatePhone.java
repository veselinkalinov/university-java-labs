package Lab.Lab_5;

public interface ValidatePhone {
    static boolean validatePhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        if (phoneNumber.length() != 10) {
            throw new WrongPhoneNumberException("Telefonniyat nomer tryabva da ima 10 tsifri.");
        }

        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);

            if (c < '0' || c > '9') {
                throw new WrongPhoneNumberException("Telefonniyat nomer tryabva da ima samo tsifri.");
            }
        }

        return true;
    }
}
