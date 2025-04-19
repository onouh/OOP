import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
     

public class Admin extends Person implements Employee<Categories>{
    private final Calendar dateOfBirth = Calendar.getInstance() ;
    private final Calendar workBegin = Calendar.getInstance();
    private final Calendar workEnd = Calendar.getInstance();
    private String role;
    Scanner input = new Scanner(System.in);
    
    Admin(){
    }
    
    Admin(String username, String password, String role, int yearOfBirth, 
          int monthOfBirth, int dayOfBirth, int start, int End) {
        super(username, password);
        this.role = role;
        this.dateOfBirth.set(Calendar.YEAR, yearOfBirth); // Corrected
        this.dateOfBirth.set(Calendar.MONTH, monthOfBirth - 1); // Corrected
        this.dateOfBirth.set(Calendar.DAY_OF_MONTH, dayOfBirth); // Corrected
        this.workBegin.set(Calendar.HOUR_OF_DAY, start); // Corrected
        this.workEnd.set(Calendar.HOUR_OF_DAY, End); // Corrected
    }
    
    
    public String getRole(){
        return role;
    }


    public int getWorkingHours(){
        return (workEnd.get(Calendar.HOUR_OF_DAY) - workBegin.get(Calendar.HOUR_OF_DAY));
    }
    
    
    public void addRoom(){
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        scanner.nextLine();
        Database.rooms.add(new Room(capacity));
    }
    
    @Override
    public void create(){
    Categories o = new Categories(input.nextLine());
    if (!o.getName().equals("<><><>")){
        Database.categories.add(o);
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
                o.setName(input.nextLine());
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
                attendees.add(p.username);
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
    String adminInfo= "Username: " + this.username + " role: " + this.role +  " Working hours: " + 
            (workEnd.get(workEnd.HOUR_OF_DAY)-workBegin.get(workBegin.HOUR_OF_DAY));  
        
    return adminInfo;
    }
    
    @Override
    public void homeScreen(){
    ArrayList<String> attendees = new ArrayList<>();
    ArrayList<String> organizers = new ArrayList<>();


    for (Person p : Database.people) {
        if (p instanceof Attendee) {
            attendees.add(p.username);
        } else if (p instanceof Organizer) {
            organizers.add(p.username);
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
        System.out.println("1-View own profile  2-show(rooms events and attendees)  3-Add a room  4-create and manage categories");
    while(true){
        String i = input.nextLine();
            switch(i){
                case "1":
                    System.out.println(this.toString());
                    break;
                case "2":
                    this.show();
                    break;
                case "3":
                    this.addRoom();
                    break;
                case "4":
                    System.out.println("What do you want to do?");
                    System.out.println("1-create category  2-read category 3-update category 4-delete category ");
                    String j = input.nextLine();
                    switch (j){
                        case "1":
                            this.create();
                            break;
                        case "2":
                            System.out.println("Which category do you want to read");
                            this.categorySelection("read");
                            break;
                        case "3":
                            System.out.println("Which category do you want to update");
                             this.categorySelection("update");
                            break;
                        case "4":
                            System.out.println("Which category do you want to delete");
                            this.categorySelection("delete");
                            break;   
                            default:System.out.println("please enter a valid option");
                    }
                break;
                default: System.out.println("please enter one of the options");
            }
        System.out.println("Do you want to log out?(y/n)");
        String choice = input.nextLine();
        while(true){
            if(choice.toLowerCase().equals("y")){
                //Main.systemStart(); (will decide name when we get there)
            }else if (choice.toLowerCase().equals("n")){
                break;
            }else{
                System.out.println("please enter y to refer to yes or n to refer to no");
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
                int k = input.nextInt();
                input.nextLine();
                do{
                    if(k < l && k >= 0 ){
                        switch(mode){
                            case "read":
                            this.read(Database.categories.get(k));
                            break;
                            case "update":
                            this.update(Database.categories.get(k));
                            break;
                            case "delete":
                            this.delete(Database.categories.get(k));
                            break;      
                        }                        break;
                    }else{
                        System.out.println("please enter a number within the valid range");
                    }
                }while(true);
                break;
            }catch(InputMismatchException ex){
                System.out.println("please enter a number");
            }
        }while(true);
    }
}