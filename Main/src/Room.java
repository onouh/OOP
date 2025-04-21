import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Room {
    static final int INITIAL_CAPACITY = 50;
    static Scanner input = new Scanner(System.in);
    private int roomNo, capacity;
    private static int roomIDCounter = 0; // Use a counter for unique room IDs
    static private int roomCost = 3000; // Use camelCase for static final variables
    private final ArrayList<Reservations> unavailableDates = new ArrayList<>(INITIAL_CAPACITY);
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public Room(int capacity) {
        this.roomNo = ++roomIDCounter; // Increment before assigning
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public int getRoomCost() {
        return roomCost;
    }

    public void setRoomCost(int roomCost) {
        Room.roomCost = roomCost;
    }

    public ArrayList<Reservations> getUnavailableDates() {
        return unavailableDates;
    }

    public String chooseAvailableTime() {
        Calendar calendar = Calendar.getInstance();
        int today = calendar.get(Calendar.DAY_OF_MONTH);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        ArrayList<String> availableSlots = new ArrayList<>();
        int slotNumber = 1;

        System.out.println("Available Time Slots (from " + DATE_FORMAT.format(calendar.getTime()) + " onwards):");

        for (int day = today + 3; day <= maxDay; day++) {
            calendar.set(Calendar.DAY_OF_MONTH, day);
            Date currentDate = calendar.getTime();
            String formattedDate = DATE_FORMAT.format(currentDate);

            boolean morningBooked = false;
            boolean nightBooked = false;

            for (Reservations reservation : unavailableDates) {
                Calendar reservationCalendar = Calendar.getInstance();
                reservationCalendar.setTime(reservation.getReservationTime().getTime());
                if (DATE_FORMAT.format(reservationCalendar.getTime()).equals(formattedDate)) {
                    if (!reservation.getDayAvailability()) {
                        morningBooked = true;
                    }
                    if (!reservation.getNightAvailability()) {
                        nightBooked = true;
                    }
                }
            }

            if (!morningBooked) {
                availableSlots.add(slotNumber + ". " + formattedDate + " - Morning");
                System.out.println(availableSlots.get(availableSlots.size() - 1));
                slotNumber++;
            }
            if (!nightBooked) {
                availableSlots.add(slotNumber + ". " + formattedDate + " - Night");
                System.out.println(availableSlots.get(availableSlots.size() - 1));
                slotNumber++;
            }
        }

        if (availableSlots.isEmpty()) {
            System.out.println("No available time slots for the rest of the month.");
            return null;
        }

        System.out.println("Please input the number of the time slot you want to reserve:");
        while (true) {
            String choice = input.nextLine();
            try {
                int slotIndex = Integer.parseInt(choice) - 1;
                if (slotIndex >= 0 && slotIndex < availableSlots.size()) {
                    return availableSlots.get(slotIndex);
                } else {
                    System.out.println("Invalid choice. Please select a number from the list.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

class Reservations {
    private Calendar reservationTime;
    private boolean dayAvailability; // true if morning is available
    private boolean nightAvailability; // true if night is available

    public Reservations(Date reservationTime, boolean dayAvailability, boolean nightAvailability) {
        this.reservationTime = Calendar.getInstance();
        this.reservationTime.setTime(reservationTime);
        this.dayAvailability = dayAvailability;
        this.nightAvailability = nightAvailability;
    }

    public Calendar getReservationTime() {
        return reservationTime;
    }

    public boolean getDayAvailability() {
        return dayAvailability;
    }

    public boolean getNightAvailability() {
        return nightAvailability;
    }

    public void setDayAvailability(boolean dayAvailability) {
        this.dayAvailability = dayAvailability;
    }

    public void setNightAvailability(boolean nightAvailability) {
        this.nightAvailability = nightAvailability;
    }
}