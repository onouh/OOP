import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends Person implements Employee<Categories>{
    private final Calendar workBegin = Calendar.getInstance();
    private final Calendar workEnd = Calendar.getInstance();
    private String role;
        
    Admin(){
        this(null,null,null, 0,0,0,0,0);
    }
    
    Admin(String username, String password, String role, int yearOfBirth, 
          int monthOfBirth, int dayOfBirth, int start, int End) {
        super(username, password, yearOfBirth, monthOfBirth, dayOfBirth);
        this.role = role; 
        this.workBegin.set(Calendar.HOUR_OF_DAY, start);
        this.workEnd.set(Calendar.HOUR_OF_DAY, End);
    }
    // This constructor is reserved for future use when Admin instances need to be initialized with specific data.
    
    
    public String getRole(){
        return role;
    }


    public int getWorkingHours(){
        return (workEnd.get(Calendar.HOUR_OF_DAY) - workBegin.get(Calendar.HOUR_OF_DAY));
    }
    
    
    public void addRoom() {
        do { 
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Enter the capacity of the room:");
                int capacity = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                try {
                    if (capacity <= 0) {
                        throw new InputMismatchException("Capacity must be a positive integer.");
                    } else {
                        Database.rooms.add(new Room(capacity));
                        System.out.println("Room added successfully.");
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a positive integer for capacity.");
                    return;
                }
            }  
        } while (true);
    }
    
    @Override
    public void create(){
        try (Scanner scanner = new Scanner(System.in)) {
            Categories o = new Categories(scanner.nextLine());
            if (!o.getName().equals("<><><>")){
                Database.categories.add(o);
            }
        }
    }

    @Override
    public void read(Categories o){
        System.out.println(o.getName());
    }
    
    @Override 
    public void update(Categories o){
        for(Categories c : Database.categories){
            if(o == c){
                try (Scanner scanner = new Scanner(System.in)) {
                    o.setName(scanner.nextLine());
                }
                break;
            }
        }
    }
    
    @Override
    public void delete(Categories o){
        int index;
        index= Database.categories.indexOf(o);
        Database.categories.remove(index);
    }
    
    @Override
    public void show(){
        System.out.printf("%-20s %-20s %-20s %n", "rooms","events","attendees" );
        ArrayList<String> attendees = new ArrayList<>();
        for(Person p:Database.people){
            if(p instanceof Attendee){
                attendees.add(p.getUsername());
            }
        }
        int max1 = Math.max(Database.events.size(),Database.rooms.size());
        int max= Math.max(attendees.size(), max1);
        for(int i = 0 ; i < max ; i++){
        String room = (i<Database.rooms.size()? String.valueOf(Database.rooms.get(i).getRoomNo()) : "");
        String event = (i<Database.events.size()? Database.events.get(i).getName() : "");
        String attendee = (i<attendees.size()? attendees.get(i) : "");
        
        System.out.printf("%-20s %-20s %-20s %n", room,event,attendee );
        }
    }
    
    @Override
    public String toString(){
    String adminInfo= "Username: " + this.getUsername() + " role: " + this.role +  " Working hours: " + 
            (workEnd.get(Calendar.HOUR_OF_DAY)-workBegin.get(Calendar.HOUR_OF_DAY));  
        
    return adminInfo;
    }
    
    @Override
    public void homeScreen(){
    ArrayList<String> attendees = new ArrayList<>();
    ArrayList<String> organizers = new ArrayList<>();


    for (Person p : Database.people) {
        if (p instanceof Attendee) {
            attendees.add(p.getUsername());
        } else if (p instanceof Organizer) {
            organizers.add(p.getUsername());
        }
    }
    
    System.out.printf("%-20s %-20s %-20s%n", "Attendees", "Organizers", "Events");
    int max1 = Math.max(organizers.size(), Database.events.size());
    int max = Math.max(attendees.size(), max1);

    for (int i = 0; i < max; i++) {
        String attendee = (i < attendees.size() ? attendees.get(i) : "");
        String organizer = (i < organizers.size() ? organizers.get(i) : "");
        String event = (i < Database.events.size() ? Database.events.get(i).getName() : "");

        System.out.printf("%-20s %-20s %-20s%n", attendee, organizer, event);
    }
        System.out.println("What would you like to do?");
        System.out.println("1-View own profile");
        System.out.println("2-show(rooms events and attendees)");
        System.out.println("3-Add a room");
        System.out.println("4-create and manage categories");
        System.out.println("5-Logout");
        while(true){
            try (Scanner scanner = new Scanner(System.in)) {
                String i = scanner.nextLine();
                    switch (i) {
                        case "1" -> System.out.println(this.toString());
                        case "2" -> this.show();
                        case "3" -> this.addRoom();
                        case "4" -> {
                            System.out.println("What do you want to do?");
                            System.out.println("1-create category  2-read category 3-update category 4-delete category ");
                            String j = input.nextLine();
                            switch (j) {
                                case "1" -> this.create();
                                case "2" -> {
                                    System.out.println("Which category do you want to read");
                                    this.categorySelection("read");
                                }
                                case "3" -> {
                                    System.out.println("Which category do you want to update");
                                    this.categorySelection("update");
                                }
                                case "4" -> {
                                    System.out.println("Which category do you want to delete");
                                    this.categorySelection("delete");
                                }
                                default -> System.out.println("please enter a valid option");
                            }
                        }
                        case "5" ->{
                    System.out.println("Are you sure you want to log out?(y/n)");
                    String choice = input.nextLine();
                    while(true){
                        switch (choice.toLowerCase()) {
                            case "y" -> {
                                App.main(null);
                            }
                            case "n" -> {

                            }
                            default -> {
                                System.out.println("please enter y to refer to yes or n to refer to no");
                                continue;
                            }
                        }
                        break;
                    }                
                        }
                        default -> System.out.println("please enter one of the options");
                    }
            }
        }
    }  
    
    private void categorySelection(String mode){
        int l = 0;
        for(Categories c : Database.categories){
            System.out.println(l + " " + c.getName());
            l++;
        }
        do{
            try{
                try (Scanner scanner = new Scanner(System.in)) {
                    int k = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                        if(k < l && k >= 0 ){
                            switch (mode) {
                                case "read" -> this.read(Database.categories.get(k));
                                case "update" -> this.update(Database.categories.get(k));
                                case "delete" -> this.delete(Database.categories.get(k));
                            }
                            break;
                        }else{
                            System.out.println("please enter a number within the valid range");
                        }
                }
                break;
            }catch(InputMismatchException ex){
                System.out.println("please enter a number in range");
            }
        }while(true);
    }
}