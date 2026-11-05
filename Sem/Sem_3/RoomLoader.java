package Sem.Sem_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RoomLoader implements Reservable {
    private Room[] rooms;

    public Room[] getRooms() {
        return rooms;
    }

    @Override
    public void updateAvailabilityFromFile() throws IOException {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("rooms.txt"))) {
            while (reader.readLine() != null) {
                count++;
            }
        }

        Room[] loaded = new Room[count];

        try (BufferedReader reader = new BufferedReader(new FileReader("rooms.txt"))) {
            for (int i = 0; i < count; i++) {
                String line = reader.readLine();
                String[] data = line.split("\\*", -1);

                if (data.length != 5) {
                    throw new InvalidRoomDataException("Nevaliden red: " + line);
                }

                try {
                    int code = Integer.parseInt(data[0]);
                    int roomNumber = Integer.parseInt(data[1]);
                    String roomType = data[2];
                    double price = Double.parseDouble(data[3]);
                    int nights = Integer.parseInt(data[4]);

                    if (roomNumber <= 0 || price <= 0 || nights < 0) {
                        throw new InvalidRoomDataException("Nevalidni danni: " + line);
                    }

                    if (code == 1 && roomType.equals("Single")) {
                        loaded[i] = new SingleRoom(roomNumber, roomType, price, nights, "edinichno");
                    } else if (code == 2 && roomType.equals("Suite")) {
                        loaded[i] = new SuiteRoom(roomNumber, roomType, price, nights, 3);
                    } else {
                        throw new InvalidRoomDataException("Nevaliden tip staia: " + line);
                    }
                } catch (NumberFormatException e) {
                    throw new InvalidRoomDataException("Nevalidno chislo: " + line);
                }
            }
        }

        rooms = loaded;
    }
}
