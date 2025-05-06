package com.example.app_gui;


//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
//import java.util.*;
//
//public class App_1 {
//
//
//
//    static Scanner input = new Scanner(System.in);
//    static Calendar calendar = Calendar.getInstance();
//    static Calendar calendar1 = Calendar.getInstance();
//    static Calendar calendar2 = Calendar.getInstance();
//    static Calendar calendar3 = Calendar.getInstance();
//    static {
//        calendar1.set(2025, Calendar.JULY, 4 );
//        calendar2.set(2025, Calendar.AUGUST, 15);
//        calendar3.set(2025, Calendar.SEPTEMBER, 27);
//    }
//
//
//    static Attendee attendee1  = new Attendee(new Wallet(25000), Gender.MALE, "Nasr City", new ArrayList<>(List.of("Birthdays", "Football", "Tv Shows")), "Mohamed", "MyPassword", 1, 1, 2000 );
//    static Attendee attendee2 = new Attendee(new Wallet(20000), Gender.FEMALE, "Tagamo3", new ArrayList<>(List.of("Wedding", "Movies", "Skating")), "Mariam", "MyPassword", 2, 2, 2000 );
//    static Attendee attendee3 = new Attendee(new Wallet(15000), Gender.MALE, "Rehab", new ArrayList<>(List.of("Parties", "Snorkling", "Bachelor Party")), "Omar", "MyPassword", 5, 5, 2000 );
//
//    static Room room1 = new Room(100);
//    static Room room2 = new Room(60);
//    static Room room3 = new Room(30);
//
//    static Categories Wedding = new Categories("Wedding");
//    static Categories Birthday = new Categories("Birthday Party");
//    static Categories Conference = new Categories("Conference");
//
//    static Organizer organizer1 = new Organizer("Maged", "MyPassword", 3, 3, 2000, 50000);
//    static Organizer organizer2 = new Organizer("Farah", "MyPassword", 4, 4, 2000, 40000);
//    static Organizer organizer3= new Organizer("Sarah", "MyPassword", 6, 6, 2000, 30000);
//
//    static Admin admin = new Admin("Noah", "MyPassword", "Developer", 1990, 5, 5,8, 18);
//
//
//    static Event event1 = new Event("Ali's Wedding", Wedding , 1000, calendar1, room1, organizer1, "Morning");
//    static  Event event2 = new Event("John's Birthday", Birthday , 500, calendar2, room3, organizer2, "Morning");
//    static Event event3 = new Event("Siemens Conference", Conference , 700, calendar3, room2, organizer3, "Morning");
//
//
//    static {
//        Database.people.addAll(Arrays.asList(attendee1,attendee2, attendee3, organizer1, organizer2, organizer3, admin));
//        Database.events.addAll(Arrays.asList(event1, event2, event3));
//        Database.rooms.addAll(Arrays.asList(room1, room2, room3));
//        Database.categories.addAll(Arrays.asList(Wedding, Birthday, Conference));
//    }
//    
//   
//
//
//
//    public static void clearInputBuffer(Scanner scanner) {
//        if (scanner.hasNextLine()) {
//            scanner.nextLine(); // Read and discard the leftover newline or input
//        }
//    }
//
//    public static void main(String[] args){
//        
//
//
//                    
//                case "3" -> {
//                    System.exit(0);
//                }
//                default -> {
//                    System.out.println("Invalid Input. Try again.");
//                }
//            }
//        }
//    }
//    public static Date parseDate(String dateStr, String format) throws ParseException {
//        SimpleDateFormat dateformat = new SimpleDateFormat(format);
//        dateformat.setLenient(false); // Strict parsing
//        return dateformat.parse(dateStr);
//    }
//}
