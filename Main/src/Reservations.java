import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Reservations {
    private Calendar Reservationtime = Calendar.getInstance();
    boolean nightAvailable;
    boolean dayAvailable;
    static Scanner input = new Scanner(System.in);

    public Reservations() {
    }

    public Reservations(boolean nightAvailable, boolean dayAvailable) {
        this.nightAvailable = true;
        this.dayAvailable = true;
    }

    public void reserve(Room room, Calendar reservetime, String choice) {
        this.Reservationtime = reservetime;
        System.out.println("please enter 1 for morning and 2 for night reservation");
        boolean continueInput = true;
        do {
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    this.dayAvailable = false;
                    continueInput = false;
                    break;
                case "2":
                    this.nightAvailable = false;
                    continueInput = false;
                    break;
                default:
                    System.out.println("proper input must be either 1 or 2");
                    break;
            }
        } while (continueInput);
        room.getUnavalabledates().add(this);
    }

    public boolean getDayAvalability() {
        return this.dayAvailable;
    }

    public boolean getnightAvalability() {
        return this.nightAvailable;
    }

    public Calendar getReservationTime() {
        return this.Reservationtime;
    }
}