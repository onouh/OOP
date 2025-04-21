package com.mycompany.curroop;

import java.util.Calendar;
import java.util.Scanner;

public class Reservations {
    private Calendar Reservationtime=Calendar.getInstance();
    private boolean nightAvailable ;
    private boolean dayAvailable ;
    static Scanner input = new Scanner(System.in);

    public Reservations() {
        this.nightAvailable = true;
        this.dayAvailable = true;
    }
    
    public void reserve(Room room,Calendar reserveTime,String DnN){
        this.Reservationtime = reserveTime;
        System.out.println("please enter 1 for morning and 2 for night reservation");
        boolean continueInput =true;
        do{
            String choice = input.nextLine();
                switch(DnN){
                    case "Morning" : 
                        this.dayAvailable = false;
                        continueInput = false;
                        break;
                    case "Night" : 
                        this.nightAvailable = false;
                        continueInput = false;
                        break;
                    default: 
                        System.out.println("proper input must be either 1 or 2");
                        break;
                }
        }while(continueInput);
        room.getUnavalableDates().add(this);
        
    }
    
    public boolean getDayAvalability() {
        return this.dayAvailable;
    }
    
    public boolean getnightAvalability() {
        return this.nightAvailable;
    }
    
    public Calendar getReservationTime() {
        return this.Reservationtime;
    }
}
