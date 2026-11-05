package Sem.Sem_3;

public class SuiteRoom extends Room {
    private int numberOfRooms;

    public SuiteRoom(int roomNumber, String roomType, double pricePerNight,
            int availableNights, int numberOfRooms) {
        super(roomNumber, roomType, pricePerNight, availableNights);
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public String toString() {
        return super.toString() + ", broi pomeshteniya: " + numberOfRooms;
    }
}
