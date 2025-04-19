public class Ticket {
    private String ticketID;
    private String eventName;
    private String eventDate;
    private String eventTime;
    private String eventLocation;
    private double ticketPrice;

    public Ticket(String ticketID, String eventName, String eventDate, String eventTime, String eventLocation, double ticketPrice) {
        this.ticketID = ticketID;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventLocation = eventLocation;
        this.ticketPrice = ticketPrice;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID='" + ticketID + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", eventTime='" + eventTime + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
    public void printTicketDetails() {
        System.out.println("Ticket ID: " + ticketID);
        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Event Time: " + eventTime);
        System.out.println("Event Location: " + eventLocation);
        System.out.println("Ticket Price: $" + ticketPrice);
    }
    public void cancelTicket() {
        System.out.println("Ticket with ID " + ticketID + " has been canceled.");
    }
    public void transferTicket(String newOwner) {
        System.out.println("Ticket with ID " + ticketID + " has been transferred to " + newOwner + ".");
    }
    public void updateTicketDetails(String newEventName, String newEventDate, String newEventTime, String newEventLocation, double newTicketPrice) {
        this.eventName = newEventName;
        this.eventDate = newEventDate;
        this.eventTime = newEventTime;
        this.eventLocation = newEventLocation;
        this.ticketPrice = newTicketPrice;
        System.out.println("Ticket details updated successfully.");
    }
    
}
