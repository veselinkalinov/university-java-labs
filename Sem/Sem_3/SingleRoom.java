package Sem.Sem_3;

public class SingleRoom extends Room {
    private String bedCategory;

    public SingleRoom(int roomNumber, String roomType, double pricePerNight, int availableNights, String bedCategory) {
        super(roomNumber, roomType, pricePerNight, availableNights);
        this.bedCategory = bedCategory;
    }

    public String getBedCategory() {
        return bedCategory;
    }

    public void setBedCategory(String bedCategory) {
        this.bedCategory = bedCategory;
    }

    @Override
    public String toString() {
        return super.toString() + ", leglo: " + bedCategory;
    }
}
