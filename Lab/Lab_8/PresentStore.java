package Lab.Lab_8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class PresentStore implements Serializable {
    private ArrayList<GetProductsTo> products;
    private ArrayList<DeliveryAPI> devApi;

    public PresentStore() {
        products = new ArrayList<>();
        devApi = new ArrayList<>();
    }

    public void addProduct(GetProductsTo product, DeliveryAPI delivery) {
        if (product == null || delivery == null || product != delivery) {
            throw new IllegalArgumentException("Trqbva da se podade edin i sasht obekt.");
        }

        products.add(product);
        devApi.add(delivery);
    }

    public ArrayList<GetProductsTo> getProductsCheaperThan(double maxPrice)
            throws ProductNotFoundException {
        ArrayList<GetProductsTo> result = new ArrayList<>();

        for (GetProductsTo product : products) {
            if (product.getPrice() < maxPrice) {
                result.add(product);
            }
        }

        if (result.isEmpty()) {
            throw new ProductNotFoundException("Nqma produkti pod tazi cena.");
        }

        return result;
    }

    public ArrayList<DeliveryAPI> getProductsByProvider(int idOfProvider)
            throws ProductNotFoundException {
        ArrayList<DeliveryAPI> result = new ArrayList<>();

        for (DeliveryAPI product : devApi) {
            if (product.getIdOfProvider() == idOfProvider) {
                result.add(product);
            }
        }

        if (result.isEmpty()) {
            throw new ProductNotFoundException("Nqma produkti za tozi dostavchik.");
        }

        return result;
    }

    public void saveToFile(String fileName) throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName))) {
            output.writeObject(this);
        }
    }

    public static PresentStore loadFromFile(String fileName)
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) {
            return (PresentStore) input.readObject();
        }
    }
}
