import java.util.ArrayList;

public class Event {
    static int intialCapacity = 1000;
    private String name;
    private Categories category;
    private int ticketPrice;
    private Organizer madeBy;
    ArrayList<Attendee> inEvent = new ArrayList<Attendee>(intialCapacity);

    Event(){

    }

    Event(String name , Categories category , int ticketPrice){
        this.name = name;
        this.category = category;
        this.ticketPrice = ticketPrice;

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

    public ArrayList<Attendee> getAttendee(){
        return inEvent;
    }


}
