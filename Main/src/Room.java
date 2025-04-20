import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Room {
    private int roomid, capacity;
    static private int roomcost = 3000;

    Calendar calendar = Calendar.getInstance();
    int today = calendar.get(Calendar.DAY_OF_MONTH);
    int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy (EEEE)");

    private String[][] availdayperiods = new String[maxDay][2];

    {

        for (int day = today; day < maxDay-2; day++) {
            calendar.set(Calendar.DAY_OF_MONTH, day + 3); //a2al 7aga 3 ayam abl el reseravtion
            String theDate = dateFormat.format(calendar.getTime());
            availdayperiods[day][0] = theDate + " - Morning";
            availdayperiods[day][1] = theDate + " - Night";
        }

        System.out.println("Available Days (from today to end of month):");
        for (int day = today; day < maxDay-2; day++) {
            for (int i = 0; i < 2; i++) {
                System.out.println(availdayperiods[day][i]);
            }
        }
    }

    public Room(int capacity) {
        this.capacity = capacity;
    }

    // Rest of your methods...
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRoomID() {
        return roomid;
    }

    public void setRoomID(int roomid) {
        this.roomid = roomid;
    }

    public int getRoomCost() {
        return roomcost;
    }

    public void setRoomCost(int roomcost) {
        this.roomcost = roomcost;
    }


}