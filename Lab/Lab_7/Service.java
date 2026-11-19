package Lab.Lab_7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Service implements Serializable {
    private ArrayList<Device> healthyDevices;
    private ArrayList<BrokenDevice> brokenDevices;

    public Service() {
        healthyDevices = new ArrayList<>();
        brokenDevices = new ArrayList<>();
    }

    public void input(Scanner scanner) {
        healthyDevices.clear();
        brokenDevices.clear();

        System.out.print("Broi zdravi ustroistva: ");
        int healthyCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < healthyCount; i++) {
            System.out.println("Zdravo ustroistvo " + (i + 1) + ":");
            Device device = new Device();
            device.input(scanner);
            addNewDevice(device);
        }

        System.out.print("Broi povredeni ustroistva: ");
        int brokenCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < brokenCount; i++) {
            System.out.println("Povredeno ustroistvo " + (i + 1) + ":");
            BrokenDevice device = new BrokenDevice();
            device.input(scanner);
            acceptBrokenDevice(device);
        }
    }

    public void display() {
        System.out.println("Zdravi ustroistva:");
        if (healthyDevices.isEmpty()) {
            System.out.println("Nyama zdravi ustroistva.");
        }
        for (int i = 0; i < healthyDevices.size(); i++) {
            System.out.print((i + 1) + ". ");
            healthyDevices.get(i).display();
        }

        System.out.println("Povredeni ustroistva:");
        if (brokenDevices.isEmpty()) {
            System.out.println("Nyama povredeni ustroistva.");
        }
        for (int i = 0; i < brokenDevices.size(); i++) {
            System.out.print((i + 1) + ". ");
            brokenDevices.get(i).display();
        }
    }

    public void addNewDevice(Device device) {
        healthyDevices.add(device);
    }

    public void acceptBrokenDevice(BrokenDevice device) {
        brokenDevices.add(device);
    }

    public boolean repairDevice(int number) {
        if (number < 1 || number > brokenDevices.size()) {
            return false;
        }

        BrokenDevice broken = brokenDevices.remove(number - 1);
        Device repaired = new Device(broken.getBrand(), broken.getModel(), broken.getPrice());
        healthyDevices.add(repaired);
        return true;
    }

    public void printDevicesWithSymptom(String symptom) {
        boolean found = false;

        for (int i = 0; i < brokenDevices.size(); i++) {
            BrokenDevice device = brokenDevices.get(i);
            if (device.getSymptoms().toLowerCase().contains(symptom.toLowerCase())) {
                System.out.print((i + 1) + ". ");
                device.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Nyama ustroistva s tozi simptom.");
        }
    }

    public double calculateTotalPrice() {
        double total = 0;

        for (Device device : healthyDevices) {
            total += device.getPrice();
        }
        for (BrokenDevice device : brokenDevices) {
            total += device.getPrice();
        }

        return total;
    }

    public double calculatePotentialRevenue(double pricePerDay) {
        double revenue = 0;

        for (BrokenDevice device : brokenDevices) {
            revenue += device.getRepairDays() * pricePerDay;
        }

        return revenue;
    }

    public void saveToFile(String fileName) throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName))) {
            output.writeObject(this);
        }
    }

    public static Service loadFromFile(String fileName)
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Service) input.readObject();
        }
    }
}
