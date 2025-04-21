import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Person {

    private String username;
    private String password;
    private final Calendar dateOfBirth = Calendar.getInstance() ;
    protected boolean loggedIn;
    static Scanner input = new Scanner(System.in);
    
    Person(){
    }
    
    Person(String username,String password, int yearOfBirth, int monthOfBirth, int dayOfBirth){
    while (true) {
        boolean taken = false;

        for (Person p : Database.people) {
            if (username.equals(p.username)) {
                taken = true;
                break;
            }
        }

        if (!taken) {
            break; // username is available!
        }

        System.out.println("Username already taken. Please enter a new username:");
        username = input.nextLine(); // read new username from user
        
    }
        this.username = username;
        this.loggedIn = false;
        this.password = password;
        this.dateOfBirth.set(Calendar.YEAR, yearOfBirth);
        this.dateOfBirth.set(Calendar.MONTH, monthOfBirth - 1);
        this.dateOfBirth.set(Calendar.DAY_OF_MONTH, dayOfBirth);
    }

    protected String getUsername(){
    return this.username;
    }
    
    protected String getPassword(){
    return this.password;
    }
    protected boolean getLoggedIn(){
    return this.loggedIn;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Person enemy) {
            return this.username.equals(enemy.username);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }

    public static final void LogIn(){       
        System.out.println("Please write your username: ");
        String username = input.nextLine();
        for(Person p : Database.people){
            if (username.equals(p.username)){
                int wrongCount = 0 ;
                System.out.println("Username found. Please enter your password: ");
                while (wrongCount >= 3){    
                    String password = input.nextLine();
                    
                    if (password.equals(p.password)){
                        p.loggedIn = true;
                    }else{
                    wrongCount++;
                        System.out.println("Please input the correct password");
                    }
                    if(wrongCount == 3){
                        System.out.println("Failed to input password");
                        //Main.systemStart(); (will decide name when we get there)
                    }
                }
                if (p.loggedIn){
                    System.out.println("Login successful");
                    switch (p) {
                        case Attendee w -> w.homeScreen();
                        case Organizer w -> w.homeScreen();
                        case Admin w -> w.homeScreen();
                        default -> {
                            // Handle the case where p is not Attendee, Organizer, or Admin
                            System.out.println("Unknown person type");
                        }
                    }
                }
                else{
                    System.out.println("you failed to place the correct password");
                    LogIn();
                }
            }
            else{
                System.out.println("username not found double check to make sure you arn't making a mistake and try again");
                LogIn();
            }
        }
    }

    protected void inputDate(Calendar cal){
    boolean continueInput = true; 
    do{
        try{
            cal.setLenient(false);
            System.out.println("please enter the day");
            cal.set(Calendar.DAY_OF_MONTH, input.nextInt());
            input.nextLine();
            
            System.out.println("please enter the month");
            cal.set(Calendar.MONTH, (input.nextInt()-1));
            input.nextLine();
            
            System.out.println("please enter the year");
            cal.set(Calendar.YEAR, input.nextInt());
            input.nextLine();
            
            continueInput = false;
        }
        catch(InputMismatchException ex){
            System.out.println("please enter numbers only");
            input.nextLine();
        }
        catch(IllegalArgumentException ex){
            System.out.println("Make sure the date you inputted is correct");
            input.nextLine();
        }
    }while(continueInput);
    }
    public abstract void homeScreen();
    protected void setUsername(String username){
        this.username = username;
    }
    protected void setPassword(String password){
        this.password = password;
    }   
    @Override   
    public abstract String toString();
    
}
