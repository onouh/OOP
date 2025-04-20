package com.mycompany.curroop;
import java.util.Calendar;
import java.util.Scanner;

public class Reservations {
    private Calendar Reservationtime=Calendar.getInstance();
    boolean nightAvalable ;
    boolean dayAvalable ;
    static Scanner input = new Scanner(System.in);
    public Reservations() {
    }

    public Reservations(boolean nightAvalable, boolean dayAvalable) {
        this.nightAvalable = true;
        this.dayAvalable = true;
    }
    
    public void reserve(Room room,Calendar reservetime , String choice){
        this.Reservationtime = reservetime;
        System.out.println("please enter 1 for morning and 2 for night reservation");
        boolean continueInput =true;
        do{
            choice = input.nextLine();
                switch(choice){
                    case "1" : 
                        this.dayAvalable = false;
                        continueInput = false;
                        break;
                    case "2" : 
                        this.nightAvalable = false;
                        continueInput = false;
                        break;
                    default: 
                        System.out.println("proper input must be either 1 or 2");
                        break;
                }
        }while(continueInput);
        room.get;
        
        
    }
    
}
