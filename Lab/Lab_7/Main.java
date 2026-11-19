package Lab.Lab_7;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "devices.dat";
        Service service = new Service();

        if (new File(fileName).exists()) {
            try {
                service = Service.loadFromFile(fileName);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Greshka pri zarezhdane na faila.");
                scanner.close();
                return;
            }
        }

        int choice;
        do {
            System.out.println("\n1. Dobavi novo zdravo ustroistvo");
            System.out.println("2. Priemi povredeno ustroistvo");
            System.out.println("3. Popravi ustroistvo");
            System.out.println("4. Tarsi po simptom");
            System.out.println("5. Obshta cena na ustroistvata");
            System.out.println("6. Ochakvani prihodi ot popravki");
            System.out.println("7. Pokazhi vsichki ustroistva");
            System.out.println("8. Vavedi spisacite nanovo");
            System.out.println("0. Izhod");
            System.out.print("Izbor: ");
            choice = Integer.parseInt(scanner.nextLine());
            boolean changed = false;

            switch (choice) {
                case 1:
                    Device device = new Device();
                    device.input(scanner);
                    service.addNewDevice(device);
                    changed = true;
                    break;
                case 2:
                    BrokenDevice broken = new BrokenDevice();
                    broken.input(scanner);
                    service.acceptBrokenDevice(broken);
                    changed = true;
                    break;
                case 3:
                    service.display();
                    System.out.print("Nomer na popravenoto ustroistvo ot povredenite: ");
                    int number = Integer.parseInt(scanner.nextLine());
                    if (service.repairDevice(number)) {
                        System.out.println("Ustroistvoto e popraveno.");
                        changed = true;
                    } else {
                        System.out.println("Nevaliden nomer.");
                    }
                    break;
                case 4:
                    System.out.print("Simptom za tarsene: ");
                    String symptom = scanner.nextLine();
                    service.printDevicesWithSymptom(symptom);
                    break;
                case 5:
                    System.out.println("Obshta cena: " + service.calculateTotalPrice());
                    break;
                case 6:
                    System.out.print("Cena za edin raboten den: ");
                    double pricePerDay = Double.parseDouble(scanner.nextLine());
                    System.out.println("Ochakvani prihodi: "
                            + service.calculatePotentialRevenue(pricePerDay));
                    break;
                case 7:
                    service.display();
                    break;
                case 8:
                    service.input(scanner);
                    changed = true;
                    break;
                case 0:
                    System.out.println("Krai na programata.");
                    break;
                default:
                    System.out.println("Nevaliden izbor.");
            }

            if (changed) {
                try {
                    service.saveToFile(fileName);
                } catch (IOException e) {
                    System.out.println("Greshka pri zapis na faila.");
                }
            }
        } while (choice != 0);

        scanner.close();
    }
}
