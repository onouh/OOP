import java.util.Calendar;


public class Room {

    private static int roomID = 0 ;
    private int roomNo;
    private int capacity;
    
    
    
    public Room( Calendar availableHours, int capacity) {
        roomNo = roomID;
        roomID++;
        this.capacity = capacity;
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
}
