package com.mycompany.oopproject;
import java.util.Scanner;
import java.util.Calendar;
import java.util.InputMismatchException;

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
                        System.out.println("Wrong password please try again");
                    }
                    if (wrongCount == 3){
                        System.out.println("failed to input proper password");
                    //    App.systemStart(); we will decide what it is called when we start making the main function
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

    protected void inputDate(Calendar cal){
    boolean continueInput = true; 
    do{
        try{
            cal.setLenient(false);
            System.out.println("please enter the day");
            cal.set(cal.DAY_OF_MONTH, input.nextInt());
            
            System.out.println("please enter the month");
            cal.set(cal.MONTH, (input.nextInt()-1));
            
            System.out.println("please enter the year");
            cal.set(cal.YEAR, input.nextInt());
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
            
    @Override   
    public abstract String toString();
    
    protected abstract void homeScreen();
}
