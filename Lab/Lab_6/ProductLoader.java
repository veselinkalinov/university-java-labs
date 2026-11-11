package Lab.Lab_6;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ProductLoader implements ImportData {
    @Override
    public Object[] importDataFromFile() throws IOException, ClassNotFoundException {
        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("salesproducts.ser"))) {
            return (Object[]) input.readObject();
        }
    }
}
