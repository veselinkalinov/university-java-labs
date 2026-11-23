package Lab.Lab_8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PresentStore store = new PresentStore();

            Product1 product1 = new Product1("Meche", 25.50, 101, 12);
            Product2 product2 = new Product2("Chasha", 15.00, 101, 8);
            Product3 product3 = new Product3("Kniga", 38.00, 202, 5);
            Product1 product4 = new Product1("Kartichka", 4.50, 202, 20);

            store.addProduct(product1, product1);
            store.addProduct(product2, product2);
            store.addProduct(product3, product3);
            store.addProduct(product4, product4);

            store.saveToFile("presentStore.dat");
            PresentStore loadedStore = PresentStore.loadFromFile("presentStore.dat");

            System.out.print("Vavedi maksimalna cena: ");
            double maxPrice = scanner.nextDouble();

            try {
                ArrayList<GetProductsTo> found = loadedStore.getProductsCheaperThan(maxPrice);
                System.out.println("Produkti pod zadadenata cena:");

                for (GetProductsTo product : found) {
                    System.out.println("Tip: " + product.getType()
                            + ", Cena: " + product.getPrice());
                }
            } catch (ProductNotFoundException e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Vavedi ID na dostavchik: ");
            int idOfProvider = scanner.nextInt();

            try {
                ArrayList<DeliveryAPI> found = loadedStore.getProductsByProvider(idOfProvider);
                System.out.println("Produkti na dostavchika:");

                for (DeliveryAPI product : found) {
                    System.out.println("Tip: " + product.getType(idOfProvider)
                            + ", Nalichnost: " + product.getNumber(idOfProvider));
                }
            } catch (ProductNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } catch (InvalidProductException | IOException | ClassNotFoundException e) {
            System.out.println("Greshka: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Nevalidni vhodni danni.");
        }
    }
}
