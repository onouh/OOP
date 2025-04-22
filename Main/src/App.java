import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class App {



    static Scanner input = new Scanner(System.in);
    static Calendar calendar = Calendar.getInstance();
    static Calendar calendar1 = Calendar.getInstance();
    static Calendar calendar2 = Calendar.getInstance();
    static Calendar calendar3 = Calendar.getInstance();
    static{
        calendar1.set(2025, Calendar.JULY, 4, 8, 0, 0);
        calendar2.set(2025, Calendar.AUGUST, 15, 8, 0, 0);
        calendar3.set(2025, Calendar.SEPTEMBER, 27, 8, 0, 0);
    }


    Attendee attendee1  = new Attendee(new Wallet(25000), Gender.MALE, "Nasr City", new ArrayList<>(List.of("Birthdays", "Football", "Tv Shows")), "Mohamed", "MyPassword", 1, 1, 2000 );
    Attendee attendee2 = new Attendee(new Wallet(20000), Gender.FEMALE, "Tagamo3", new ArrayList<>(List.of("Wedding", "Movies", "Skating")), "Mariam", "MyPassword", 2, 2, 2000 );
    Attendee attendee3 = new Attendee(new Wallet(15000), Gender.MALE, "Rehab", new ArrayList<>(List.of("Parties", "Snorkeling", "Bachelor Party")), "Omar", "MyPassword", 5, 5, 2000 );

    Room room1 = new Room(100);
    Room room2 = new Room(60);
    Room room3 = new Room(30);

    Categories Wedding = new Categories("Wedding");
    Categories Birthday = new Categories("Birthday Party");
    Categories Conference = new Categories("Conference");

    Organizer organizer1 = new Organizer("Maged", "MyPassword", 3, 3, 2000, 50000);
    Organizer organizer2 = new Organizer("Farah", "MyPassword", 4, 4, 2000, 40000);
    Organizer organizer3= new Organizer("Sarah", "MyPassword", 6, 6, 2000, 30000);

    Event event1 = new Event("Ali's Wedding", Wedding , 1000, calendar1, room1, organizer1);
    Event event2 = new Event("John's Birthday", Birthday , 500, calendar2, room3, organizer2);
    Event event3 = new Event("Siemens Conference", Conference , 700, calendar3, room2, organizer3);

    {
        Database.people.addAll(Arrays.asList(attendee1,attendee2, attendee3, organizer1, organizer2, organizer3));
        Database.events.addAll(Arrays.asList(event1,event2,event3));
        Database.rooms.addAll(Arrays.asList(room1,room2,room3));
        Database.categories.addAll(Arrays.asList(Wedding,Birthday,Conference));

    }



    public static void clearInputBuffer(Scanner scanner) {
        
    }

    public static void main(String[] args){
        System.out.println("Welcome to The EventHub!\n");
        System.out.println("1- Login");
        System.out.println("2- Signup");
        while(true){
            String choice = input.nextLine();
            switch(choice){
                case "1" -> {
                    Person.LogIn();
                    break;
                }
                case "2" -> {
                    System.out.println("Enter your Username: ");
                    clearInputBuffer(input);
                    // try {
                        String username = input.nextLine();
                        Person.Checkusername(username);
                        String genderstring;
                        Gender gender;

                        int day,month,year;
                        while(true){
                            System.out.println("Enter your Gender (Male/Female): ");
                            clearInputBuffer(input);
                            genderstring = input.nextLine().toLowerCase();
                            switch(genderstring){
                                case "male" -> {
                                    gender = Gender.MALE;
                                    break;
                                }
                                case "female" -> {
                                    gender = Gender.FEMALE;
                                    break;
                                }
                                default ->{
                                    System.out.println("Invalid Input. Try again");
                                    continue;
                                }
                            }
                            break;
                        }

                        System.out.println("Enter your Address: ");
                        clearInputBuffer(input);
                        String address = input.nextLine();

                        while(true){

                            System.out.println("Enter your date of birth (DD/MM/YYYY): ");
                            String datestring = input.nextLine();
                            try {
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                LocalDate date = LocalDate.parse(datestring, formatter);
                                day = date.getDayOfMonth();
                                month = date.getMonthValue();
                                year = date.getYear();

                                if (year < 1900 || year > calendar.get(Calendar.YEAR)) {
                                    System.out.println("Year is out of valid range");
                                    continue;
                                }
                                break;

                            } catch (DateTimeParseException e) {
                                System.out.println("Invalid date format or value: " + e.getMessage());
                            }
                        }
                        System.out.println("Enter your Password: ");
                        clearInputBuffer(input);
                        String password = input.nextLine();

                        double balance = 0;
                        boolean validInput = false;

                        while (!validInput) {
                            try {
                                System.out.println("Enter Your balance: ");
                                clearInputBuffer(input);
                                balance = input.nextInt();
                                if(balance >= 0) validInput = true;
                                else System.out.println("Balance cannot be negative. Please enter a valid number.");
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid number.");
                                input.next();
                            }
                        }
                        Wallet wallet = new Wallet(balance);
                        ArrayList<String> interests = new ArrayList<>(3);
                        System.out.println("Enter 3 interests that reflects your personality: ");
                        clearInputBuffer(input);
                        input.nextLine();
                        for(int j = 0; j < 3; j++) interests.add(input.nextLine());
                        Database.people.add(new Attendee(wallet, gender, address, interests ,username, password, day, month, year ));
                        for(int k=0; k < Database.people.size();k++){
                            if(Database.people.get(k).getUsername().equals(username)){
                                Database.people.get(k).homeScreen();
                            }
                        }
                    }
                // }
                default -> {
                    System.out.println("Invalid Input. Try again.");
                }
            }
            // input.close();
        }
    }
    public static Date parseDate(String dateStr, String format) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat(format);
        dateformat.setLenient(false); // Strict parsing
        return dateformat.parse(dateStr);
    }
}
