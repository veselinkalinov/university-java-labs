package Study.DeliveryCompany;

public class AdressDelivery extends Delivery implements Trackable {
    private int distanceKm;

    public AdressDelivery(String recipient, int weight, double basePrice, int distanceKm) {
        super(recipient, weight, basePrice);
        this.distanceKm = distanceKm;
    }

    public int getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(int distanceKm) {
        this.distanceKm = distanceKm;
    }

    @Override
    public double calculatedPrice() {
        double basePrice = getBasePrice();
        return basePrice + distanceKm * 2;
    }

    @Override
    public int estimateDays() {
        if (distanceKm <= 20) {
            return 1;
        } else {
            return 2;
        }
    }
}
