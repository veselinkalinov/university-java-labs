package Sem.Sem_3;

import java.io.Serializable;

public class Room implements Serializable {
    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private int availableNights;

    public Room(int roomNumber, String roomType, double pricePerNight, int availableNights) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.availableNights = availableNights;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getAvailableNights() {
        return availableNights;
    }

    public void setAvailableNights(int availableNights) {
        this.availableNights = availableNights;
    }

    public boolean reserveRoom(int numNights) throws NoAvailableNightsException {
        if (numNights <= 0) {
            throw new IllegalArgumentException("Broiat noshtuvki tryabva da e polozhitelen.");
        }

        if (numNights > availableNights) {
            throw new NoAvailableNightsException("Nqma dostatuchno noshtuvki za staia " + roomNumber);
        }

        availableNights = availableNights - numNights;
        return true;
    }

    @Override
    public String toString() {
        return "Staia " + roomNumber + ", tip: " + roomType
                + ", cena: " + pricePerNight
                + ", nalichni noshtuvki: " + availableNights;
    }
}
