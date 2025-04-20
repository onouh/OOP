
import java.util.ArrayList;
import java.util.Calendar;

public class Event {
    static int intialCapacity = 1000;
    private Room room;
    private Calendar eventTime;
    private String name;
    private Categories category;
    private int ticketPrice;
    private Organizer madeBy;
    private ArrayList<Attendee> IN_EVENT = new ArrayList<>(intialCapacity);
    private int attendeeNum;
    
    Event(){

    }

    Event(String name , Categories category , int ticketPrice){
        this.name = name;
        this.category = category;
        this.ticketPrice = ticketPrice;

    }

    public Organizer getMadeBy() {
        return madeBy;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setMadeBy(Organizer madeBy) {
        this.madeBy = madeBy;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getTicketPrice(){
        return ticketPrice;
    }
    public void setTicketPrice(int ticketPrice){
        this.ticketPrice = ticketPrice;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public ArrayList<Attendee> getAttendee(){
        return IN_EVENT;
    }

    public int getAttendeeNum() {
        return attendeeNum;
    }

    public void setAttendeeNum(int attendeeNum) {
        this.attendeeNum = attendeeNum;
    }

    public Organizer getOrganizer() {
        return madeBy;
    }
}
