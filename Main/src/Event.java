import java.util.ArrayList;

public class Event {
    static int intialCapacity = 1000;
    private String name;
    private Categories category;
    private int ticketPrice;
    private Organizer madeBy;
    private final ArrayList<Attendee> IN_EVENT = new ArrayList<>(intialCapacity);

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
}
