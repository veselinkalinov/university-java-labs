package Lab.Lab_6;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private int inventoryNumber;
    private double price;
    protected int quantity;
    private Provider provider;

    public Product(int inventoryNumber, double price, int quantity, Provider provider) {
        this.inventoryNumber = inventoryNumber;
        this.price = price;
        this.quantity = quantity;
        this.provider = provider;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Provider getProvider() {
        return provider;
    }

    public abstract double getPromotionalPrice();

    public abstract boolean sellProduct(int piece) throws NoMoreProductsException;
}
