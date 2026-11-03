package Study.DeliveryCompany;

public class Main {
    public static void main(String args[]) {
        OfficeDelivery office = new OfficeDelivery("Ivan", 50, 100, "Varna");
        AdressDelivery adress = new AdressDelivery("Gosho", 35, 20, 20);

        System.out.println("Cena: " + office.calculatedPrice());
        System.out.println("Cena: " + adress.calculatedPrice() + ", " + adress.estimateDays() + " dni/den");

        adress.setDistanceKm(21);
        System.out.println();
        System.out.println("Cena: " + adress.calculatedPrice() + ", " + adress.estimateDays() + " dni/den");

    }
}
