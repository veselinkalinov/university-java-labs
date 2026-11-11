package Lab.Lab_6;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void generateSampleFile() {
        try {
            Provider p1 = new Provider("Technopolis", "0878825124");
            Provider p2 = new Provider("Orange", "0878566753");

            Product[] products = {
                    new Electronics(868978787, 1500.0, 200, p1, "SAMSUNG", "67ABV423G"),
                    new Book(673568573, 25.99, 1000, p2, " J. R. R. Tolkien", "Lord Of The Rings")
            };

            try (ObjectOutputStream output = new ObjectOutputStream(
                    new FileOutputStream("salesproducts.ser"))) {
                output.writeObject(products);
                System.out.println("Failat salesproducts.ser e sazdaden uspeshno.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generateSampleFile();
        BlackFriday.processSales();

        for (int i = 0; i < BlackFriday.electronics.length; i++) {
            Electronics product = BlackFriday.electronics[i];
            System.out.println("Elektronika: " + product.getManufacturer() + " " + product.getModel());
            System.out.println("Promotsionalna tsena: " + product.getPromotionalPrice());
            System.out.println("Nalichnost: " + product.getQuantity());
        }

        for (int i = 0; i < BlackFriday.books.length; i++) {
            Book product = BlackFriday.books[i];
            System.out.println("Kniga: " + product.getAuthor() + " - " + product.getTitle());
            System.out.println("Promotsionalna tsena: " + product.getPromotionalPrice());
            System.out.println("Nalichnost: " + product.getQuantity());
        }
    }
}
