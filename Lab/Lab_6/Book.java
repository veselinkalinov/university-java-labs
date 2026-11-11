package Lab.Lab_6;

public class Book extends Product {
    private String author;
    private String title;

    public Book(int inventoryNumber, double price, int quantity,
            Provider provider, String author, String title) {
        super(inventoryNumber, price, quantity, provider);
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public double getPromotionalPrice() {
        return getPrice() * 0.50;
    }

    @Override
    public boolean sellProduct(int piece) throws NoMoreProductsException {
        if (piece <= 0) {
            throw new IllegalArgumentException("Broiat trqbva da e polozhitelen.");
        }
        if (piece > quantity) {
            throw new NoMoreProductsException("Nqma dostatuchno knigi.");
        }
        quantity -= piece;
        return true;
    }
}
