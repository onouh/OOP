package src;
import java.util.Date;

public class Room {

    private int roomID;
    private Date availableHours;
    private int capacity;

    public Room(int roomID, Date availableHours, int capacity) {
        this.roomID = roomID;
        this.availableHours = availableHours;
        this.capacity = capacity;
    }
    public int getRoomID() {
        return roomID;
    }
    public Date getAvailableHours() {
        return availableHours;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
    public void setAvailableHours(Date availableHours) {
        this.availableHours = availableHours;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
