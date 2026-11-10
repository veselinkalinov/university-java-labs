package Study.Session_2;

import java.io.FileReader;
import java.io.IOException;

public class TryCatchExceptions {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader(
                "C:\\Users\\vesko\\Documents\\TU - Sofia\\Semester 3\\PNPE\\Study\\Session_2\\data.txt");) {
            System.out.println("File opened");
        } catch (IOException e) {
            System.out.println("File not found " + e);
        }

    }
}
