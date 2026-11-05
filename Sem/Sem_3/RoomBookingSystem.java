package Sem.Sem_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class RoomBookingSystem {
    public static SingleRoom[] singleRooms;
    public static SuiteRoom[] suiteRooms;

    public static void processRoomReservations() {
        RoomLoader loader = new RoomLoader();

        try {
            loader.updateAvailabilityFromFile();
            Room[] rooms = loader.getRooms();

            int singleCount = 0;
            int suiteCount = 0;

            for (int i = 0; i < rooms.length; i++) {
                if (rooms[i] instanceof SingleRoom) {
                    singleCount++;
                } else if (rooms[i] instanceof SuiteRoom) {
                    suiteCount++;
                }
            }

            singleRooms = new SingleRoom[singleCount];
            suiteRooms = new SuiteRoom[suiteCount];

            int s = 0;
            int t = 0;

            for (int i = 0; i < rooms.length; i++) {
                if (rooms[i] instanceof SingleRoom) {
                    singleRooms[s] = (SingleRoom) rooms[i];
                    s++;
                } else if (rooms[i] instanceof SuiteRoom) {
                    suiteRooms[t] = (SuiteRoom) rooms[i];
                    t++;
                }
            }

            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < rooms.length; i++) {
                System.out.println(rooms[i]);
                System.out.print("Kolko noshtuvki da se rezervirat? ");
                int nights = scanner.nextInt();

                try {
                    rooms[i].reserveRoom(nights);
                    System.out.println("Uspeshna rezervaciya. Ostavat "
                            + rooms[i].getAvailableNights() + " noshtuvki.");
                } catch (NoAvailableNightsException e) {
                    System.out.println("Neuspeshna rezervaciya: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("Neuspeshna rezervaciya: " + e.getMessage());
                }
            }

            scanner.close();

            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("rooms.ser"))) {
                output.writeObject(rooms);
            }
            System.out.println("Staite sa zapisani v rooms.ser.");

            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("rooms.ser"))) {
                Room[] savedRooms = (Room[]) input.readObject();
                System.out.println("Staite ot rooms.ser:");

                for (int i = 0; i < savedRooms.length; i++) {
                    System.out.println(savedRooms[i]);
                }
            }
        } catch (InvalidRoomDataException e) {
            System.out.println("Greshka v dannite: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Greshka pri rabota s fail: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Greshka pri chetene na obekt: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        processRoomReservations();
    }
}
