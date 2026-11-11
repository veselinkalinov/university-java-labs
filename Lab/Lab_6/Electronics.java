package Lab.Lab_6;

public class Electronics extends Product {
    private String manufacturer;
    private String model;

    public Electronics(int inventoryNumber, double price, int quantity,
            Provider provider, String manufacturer, String model) {
        super(inventoryNumber, price, quantity, provider);
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    @Override
    public double getPromotionalPrice() {
        return getPrice() * 0.90;
    }

    @Override
    public boolean sellProduct(int piece) throws NoMoreProductsException {
        if (piece <= 0) {
            throw new IllegalArgumentException("Broiat trqbva da e polozhitelen.");
        }
        if (piece > quantity) {
            throw new NoMoreProductsException("Nqma dostatuchno elektronika.");
        }
        quantity -= piece;
        return true;
    }
}
