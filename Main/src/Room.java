import java.util.ArrayList;
import java.util.Calendar;


public class Room {

    private static int roomID = 0 ;
    private final int roomNo;
    private int capacity;
    private ArrayList<Calendar> availableHours;
    private int roomCost;
    
    
    Room(ArrayList<Calendar> availableHours, int capacity) {
        roomNo = roomID;
        roomID++;
        this.capacity = capacity;
    }

    public ArrayList<Calendar> getAvailableHours() {
        return availableHours;
    }

    public void setAvailableHours(ArrayList<Calendar> availableHours) {
        this.availableHours = availableHours;
    }
    
    public int getRoomNo() {
        return roomNo;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRoomCost() {
        return roomCost;
    }

    public void setRoomCost(int roomCost) {
        this.roomCost = roomCost;
    }
}
