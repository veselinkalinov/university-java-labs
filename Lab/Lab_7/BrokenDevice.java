package Lab.Lab_7;

import java.util.Scanner;

public class BrokenDevice extends Device {
    private String symptoms;
    private int repairDays;

    public BrokenDevice() {
        super();
        this.symptoms = "";
        this.repairDays = 0;
    }

    public BrokenDevice(String brand, String model, double price,
            String symptoms, int repairDays) {
        super(brand, model, price);
        this.symptoms = symptoms;
        this.repairDays = repairDays;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public int getRepairDays() {
        return repairDays;
    }

    public void setRepairDays(int repairDays) {
        this.repairDays = repairDays;
    }

    @Override
    public void input(Scanner scanner) {
        super.input(scanner);

        System.out.print("Simptomi: ");
        symptoms = scanner.nextLine();

        System.out.print("Dni za popravka: ");
        repairDays = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Simptomi: " + symptoms + ", Dni za popravka: " + repairDays);
    }
}
