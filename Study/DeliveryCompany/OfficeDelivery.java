package Study.DeliveryCompany;

public class OfficeDelivery extends Delivery {
    private String officeName;

    public OfficeDelivery(String recipient, int weight, double basePrice, String officeName) {
        super(recipient, weight, basePrice);
        this.officeName = officeName;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    @Override
    public double calculatedPrice() {
        double calc_price = getBasePrice();
        return calc_price + calc_price * 0.05;
    }
}
