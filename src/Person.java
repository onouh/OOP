package src;
import java.util.Scanner;

public abstract class Person {

    protected String username;
    protected String password;
    protected boolean loggedIn;
    Scanner input = new Scanner(System.in);
    
    Person(){
    }
    
    Person(String username,String password){
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
    }
    
    protected String getUsername(){
    return this.username;
    }
    
    protected String getPassword(){
    return this.password;
    }
    

    public boolean equals(Object o){
        if (o instanceof Person){  
            Person enemy = (Person)o;
            return this.username.equals(((Person) o).username);
        }
        else{
            return false;
        }
    }

    public void LogIn(){       
        System.out.println("Please write your username");
        String username = input.next();
        for(Person p : Database.people){
            if (username.equals(p.username)){
                int wrongCount = 0 ;
                System.out.println("Username found please enter password");
                while (wrongCount >= 3){    
                    String password = input.next();
                    if (password.equals(p.password)){
                        p.loggedIn = true;
                    }else{
                    wrongCount++;
                    }
                }
                if (loggedIn){
                    System.out.println("Login successful");
                    if(p instanceof Attendee){
                    Attendee w = (Attendee)p;
                    p.homeScreen();
                    }
                    else if(p instanceof Organizer){
                    Organizer w = (Organizer)p;
                    p.homeScreen();
                    }
                    else if(p instanceof Admin){
                    Admin w = (Admin)p;
                    p.homeScreen();
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
    @Override
    public abstract String toString();
    
    protected abstract void homeScreen();
}
