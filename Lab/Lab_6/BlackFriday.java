package Lab.Lab_6;

import java.io.IOException;

public class BlackFriday {
    public static Electronics[] electronics = new Electronics[0];
    public static Book[] books = new Book[0];

    public static void processSales() {
        ProductLoader loader = new ProductLoader();

        try {
            Object[] products = loader.importDataFromFile();
            int electronicsCount = 0;
            int booksCount = 0;

            for (int i = 0; i < products.length; i++) {
                if (products[i] instanceof Electronics) {
                    electronicsCount++;
                } else if (products[i] instanceof Book) {
                    booksCount++;
                }
            }

            electronics = new Electronics[electronicsCount];
            books = new Book[booksCount];

            int e = 0;
            int b = 0;

            for (int i = 0; i < products.length; i++) {
                if (products[i] instanceof Electronics) {
                    electronics[e] = (Electronics) products[i];
                    e++;
                } else if (products[i] instanceof Book) {
                    books[b] = (Book) products[i];
                    b++;
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Greshka pri chetene na faila: " + ex.getMessage());
        }
    }
}
