import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Scanner;

public abstract class Person {

    private String username;
    private String password;
    private final Calendar dateOfBirth = Calendar.getInstance() ;
    protected boolean loggedIn;
    static Scanner input = new Scanner(System.in);



    Person(){
        this(null,null,0,0,0);
    }
    
    Person(String username,String password, int yearOfBirth, int monthOfBirth, int dayOfBirth){

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

        while(true) {

            System.out.println("Please write your username");
            String username = input.nextLine().trim();
            if(username.equalsIgnoreCase("exit")) App.main(null);
            Person foundUser = null;
            for (Person p : Database.people) {
                if (username.equals(p.username)) {
                    foundUser = p;
                    break;
                }
            }
            if (foundUser == null) {
                System.out.println("Username not found. Try again.");
                System.out.println("If you would like to create an account, Enter exit.");
                continue;
            }

            System.out.println("Username found. Please enter password:");
            PasswordCheck(foundUser);
            if (foundUser.loggedIn) {
                System.out.println("Login successful");
                switch (foundUser) {
                    case Attendee w -> w.homeScreen();
                    case Organizer w -> w.homeScreen();
                    case Admin w -> w.homeScreen();
                    default -> {
                        System.out.println("Error 404");
                        return;
                    }
                }
            }
            return;
        }

    }
    protected Calendar inputDate () {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("please enter a day with the format (dd/MM/yyyy)");
        System.out.println("Note that you can only regester dates that are 3 days from now and no futhur than 18 days");
        System.out.println("I.E. if today is 23 of Apr. you can pick days from 26 Apr. up till 5 of May");
        while (true) {
           // input.nextLine();
            String date = input.nextLine();
            try {
                LocalDate dateInst = LocalDate.parse(date, format);
                Calendar cal = Calendar.getInstance();
                cal.set(
                        dateInst.getYear(),
                        dateInst.getMonthValue() - 1,
                        dateInst.getDayOfMonth()
                );
                return cal;
            } catch (DateTimeParseException ex) {
                System.out.println("please enter the day in the correct format dd/MM/YYYY it is very strict with the format");
            }
        }
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

    protected static void PasswordCheck(Person p){

        int wrongCount = 0 ;
        while (wrongCount < 3){
            String password = input.nextLine();

            if (password.equals(p.password)){
                p.loggedIn = true;
                break; //fixed
            }else{
                wrongCount++;
                System.out.println("Please input the correct password");
            }
            if(wrongCount == 3){
                System.out.println("failed to input password");
                App.main(null);
            }
        }
    }
    public static void Checkusername(String username){

        while (true)
        {
            boolean taken = false;

            for (Person p : Database.people)
            {
                if (username.equals(p.username))
                {
                    taken = true;
                    break;
                }
            }

            if (!taken)
            {
                break; // username is available!
            }

            System.out.println("Username already taken. Please enter a new username:");
            // input.nextLine();
            username = input.nextLine(); // read new username from user

        }




    }


    
}
