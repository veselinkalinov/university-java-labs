package Study.DeliveryCompany;

public abstract class Delivery {
    private String recipient;
    private int weight;
    private double basePrice;

    public Delivery(String recipient, int weight, double basePrice) {
        this.recipient = recipient;
        this.weight = weight;
        this.basePrice = basePrice;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public abstract double calculatedPrice();

}
