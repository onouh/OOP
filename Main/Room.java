
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Room {
    private int roomid, capacity;
    static private int roomcost = 3000;

    Calendar calendar = Calendar.getInstance();
    int today = calendar.get(Calendar.DAY_OF_MONTH);
    int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy (EEEE)");
    private ArrayList<Reservations> unavalabledates = new ArrayList<>(50);
   
    public Room(int capacity) {
        this.capacity = capacity;
    }

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

    public ArrayList getUnavalableDates(){
    return unavalabledates;
    }
    
    public void getAvalableDays(){
        System.out.println("Available Days (from today to end of month):");
        int k =1 ;        
        for (int day = today + 3; day < maxDay; day++) {

        for(Reservations r : unavalabledates){
            calendar.set(Calendar.DAY_OF_MONTH, day); 
            Date currentDate = calendar.getTime();
            String theDate = dateFormat.format(currentDate);
            if(currentDate.equals(r.getReservationTime().getTime()) ){
                if(!r.getDayAvalability()){
                }else{
                    System.out.println(k + theDate + " - Morning");
                    k++;
                }
                if(!r.getnightAvalability()){
                }else{
                    System.out.println(k + theDate + " - Night");
                    k++;
                }
            }
            }
        }
    }
}