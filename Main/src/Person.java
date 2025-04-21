import java.time.LocalDate;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
        System.out.println("Please write your username");
        String username = input.nextLine();
        for(Person p : Database.people){
            if (username.equals(p.username)){
                int wrongCount = 0 ;
                System.out.println("Username found please enter password");
                while (wrongCount >= 3){    
                    String password = input.nextLine();
                    
                    if (password.equals(p.password)){
                        p.loggedIn = true;
                    }else{
                    wrongCount++;
                        System.out.println("Please input the correct password");
                    }
                    if(wrongCount == 3){
                        System.out.println("failed to input password");
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

    protected static Calendar inputDate(){
    boolean continueInput = true; 
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    System.out.println("please enter a day with the format (dd/MM/yyyy)");
    do{
    String date = input.nextLine();
    try{
        LocalDate dateInst = LocalDate.parse(date,format);
        Calendar cal = Calendar.getInstance();
        cal.set(
        dateInst.getYear(),
        dateInst.getMonthValue()- 1,
        dateInst.getDayOfMonth()
        );
        return cal;
    }catch(DateTimeParseException ex){
        System.out.println("please enter the day in the correct format dd/MM/YYYY it is very strict with the format");
    }
    }while(continueInput);
    }
    protected abstract void homeScreen();
    protected void setUsername(String username){
        this.username = username;
    }
    protected void setPassword(String password){
        this.password = password;
    }   
    @Override   
    public abstract String toString();
    
}
