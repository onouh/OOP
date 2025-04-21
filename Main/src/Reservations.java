import java.util.Calendar;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservations {
    private Calendar reservationTime = Calendar.getInstance();
    private boolean nightAvailable = true;
    private boolean dayAvailable = true;
    private static Scanner input = new Scanner(System.in);
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public Reservations() {
    }

    public void reserve(Room room, String chosenSlot) {
        String[] parts = chosenSlot.split(" - ");
        if (parts.length == 2) {
            String datePart = parts[0];
            String timePart = parts[1];
            try {
                Date date = DATE_FORMAT.parse(datePart);
                reservationTime.setTime(date);

                if (timePart.equals("Morning")) {
                    this.dayAvailable = false;
                } else if (timePart.equals("Night")) {
                    this.nightAvailable = false;
                }
                room.getUnavailableDates().add(this);
                System.out.println("Reservation successful for: " + chosenSlot);

            } catch (ParseException e) {
                System.out.println("Error parsing the date: " + datePart);
            }
        } else {
            System.out.println("Invalid slot format: " + chosenSlot);
        }
    }

    public boolean getDayAvailability() {
        return this.dayAvailable;
    }

    public boolean getNightAvailability() {
        return this.nightAvailable;
    }

    public Calendar getReservationTime() {
        return this.reservationTime;
    }

    // You might want a constructor that directly takes a Calendar and availability
    public Reservations(Calendar reservationTime, boolean dayAvailable, boolean nightAvailable) {
        this.reservationTime = reservationTime;
        this.dayAvailable = dayAvailable;
        this.nightAvailable = nightAvailable;
    }
}