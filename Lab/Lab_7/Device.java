package Lab.Lab_7;

import java.io.Serializable;
import java.util.Scanner;

public class Device implements Serializable {
    private String brand;
    private String model;
    private double price;

    public Device() {
        this("", "", 0);
    }

    public Device(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void input(Scanner scanner) {
        System.out.print("Marka: ");
        brand = scanner.nextLine();

        System.out.print("Model: ");
        model = scanner.nextLine();

        System.out.print("Cena: ");
        price = Double.parseDouble(scanner.nextLine());
    }

    public void display() {
        System.out.println("Marka: " + brand + ", Model: " + model + ", Cena: " + price);
    }
}
