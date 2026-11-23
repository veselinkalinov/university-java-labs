package Lab.Lab_8;

import java.io.Serializable;

public class Product3 implements GetProductsTo, DeliveryAPI, Serializable {
    private String type;
    private double price;
    private int idOfProvider;
    private int number;

    public Product3(String type, double price, int idOfProvider, int number)
            throws InvalidProductException {
        if (price < 0 || number < 0) {
            throw new InvalidProductException("Cenata i nalichnostta ne mogat da sa otricatelni.");
        }

        this.type = type;
        this.price = price;
        this.idOfProvider = idOfProvider;
        this.number = number;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getNumber(int idOfProvider) {
        if (this.idOfProvider == idOfProvider) {
            return number;
        }
        return 0;
    }

    @Override
    public String getType(int idOfProvider) {
        if (this.idOfProvider == idOfProvider) {
            return type;
        }
        return null;
    }

    @Override
    public int getIdOfProvider() {
        return idOfProvider;
    }
}
