package Lab.Lab_5;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws WrongPhoneNumberException {
        Scanner scanner = new Scanner(System.in);

        User[] users = new User[10];
        users[0] = new User("ivan", "SuperPassword", "0881234567");
        int count = 1;

        while (true) {
            System.out.println("1. Registratsiya");
            System.out.println("2. Vhod");
            System.out.print("Izbor: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                if (count == users.length) {
                    System.out.println("Nqma svobodno mqsto.");
                    continue;
                }

                try {
                    System.out.print("Potrebitelsko ime: ");
                    String username = scanner.nextLine();

                    if (!UsernameValidator.validateUsername(username)) {
                        throw new WrongUserException("Nevalidno potrebitelsko ime.");
                    }

                    for (int i = 0; i < count; i++) {
                        if (users[i].getUsername().equals(username)) {
                            throw new WrongUserException("Tova potrebitelsko ime veche sushtestvuva.");
                        }
                    }

                    System.out.print("Parola: ");
                    String password = scanner.nextLine();

                    System.out.print("Povtorete parola: ");
                    String repeatedPassword = scanner.nextLine();

                    if (!PasswordValidator.validatePassword(password)) {
                        System.out.println("Parolata tryabva da e pone 11 simvola, samo bukvi.");
                        continue;
                    }

                    if (!password.equals(repeatedPassword)) {
                        System.out.println("Parolite ne suvpadat.");
                        continue;
                    }

                    System.out.print("Telefonen nomer: ");
                    String phoneNumber = scanner.nextLine();

                    users[count] = new User(username, password, phoneNumber);
                    count++;

                    System.out.println("Uspeshna registratsiya.");

                } catch (WrongUserException | WrongPhoneNumberException e) {
                    System.out.println(e.getMessage());
                }

            } else if (choice == 2) {
                System.out.print("Potrebitelsko ime: ");
                String username = scanner.nextLine();

                System.out.print("Parola: ");
                String password = scanner.nextLine();

                boolean found = false;

                for (int i = 0; i < count; i++) {
                    if (users[i].getUsername().equals(username) && users[i].getPassword().equals(password)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    System.out.println("Uspeshen vhod.");
                } else {
                    System.out.println("Greshno ime ili parola.");
                }

            } else {
                System.out.println("Nevaliden izbor.");
            }
        }
    }
}
