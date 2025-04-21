package com.mycompany.curroop;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Room {
    static Scanner input = new Scanner(System.in);
    private int roomNo, capacity;
    private static int roomID = 0;
    static private int roomcost = 3000;
    private static 
    Calendar calendar = Calendar.getInstance();
    int today = calendar.get(Calendar.DAY_OF_MONTH);
    int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private ArrayList<Reservations> unavalabledates = new ArrayList<>(50);
   
    public Room(int capacity) {
        this.roomNo = Room.roomID;
        this.capacity = capacity;
        roomID++;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public int getRoomCost() {
        return roomcost;
    }

    public void setRoomCost(int roomcost) {
        this.roomcost = roomcost;
    }

    public ArrayList getUnavalableDates(){
    return unavalabledates;
    }
    
public String[][] getAvalableRooms(){
        String[][] availableDates = new String[500][2];
        System.out.println("Available Days (from today to end of month):");
        int k =1 ;        
        int m =0 ;
        for (int day = today + 3; day < maxDay; day++) {
            boolean inHere = false;
            boolean inThere = false;
            calendar.set(Calendar.DAY_OF_MONTH, day); 
            Date currentDate = calendar.getTime();
            String theDate = dateFormat.format(currentDate);
        for(Reservations r : unavalabledates){
            if(currentDate.equals(r.getReservationTime().getTime()) ){
                if(!r.getDayAvalability()){
                inHere=true;
                }else{
                    availableDates[k-1][0] =theDate + " - Morning";
                    inHere=true;
                    k++;
                }
                if(!r.getnightAvalability()){
                inThere = true;
                }else{
                    availableDates[k-2][1] =theDate + " - Night";
                    inThere = true;
                    k++;
                }
            }           
            }   
                if(!inHere){
                availableDates[k-1][0] = theDate + " - Morning";
                k++;
                }
                if(!inThere){
                availableDates[k-2][1] = theDate + " - Night";
                k++;
                }
        }
        return availableDates;
}
    
    public String chooseAvalableTimes(){
                String[][] availableDates = new String[500][2];
        System.out.println("Available Days (from today to end of month):");
        int k =1 ;        
        int m =0 ;
        for (int day = today + 3; day < maxDay; day++) {
            boolean inHere = false;
            boolean inThere = false;
            calendar.set(Calendar.DAY_OF_MONTH, day); 
            Date currentDate = calendar.getTime();
            String theDate = dateFormat.format(currentDate);
        for(Reservations r : unavalabledates){
            if(currentDate.equals(r.getReservationTime().getTime()) ){
                if(!r.getDayAvalability()){
                inHere=true;
                }else{
                    availableDates[k-1][0] =theDate + " - Morning";
                    System.out.println(k + availableDates[k-1][0]);
                    inHere=true;
                    k++;
                }
                if(!r.getnightAvalability()){
                inThere = true;
                }else{
                    availableDates[k-2][1] =theDate + " - Night";
                    inThere = true;
                    k++;
                }
            }           
            }   
                if(!inHere){
                availableDates[k-1][0] = theDate + " - Morning";
                System.out.println(k + availableDates[k-1][0]);
                k++;
                }
                if(!inThere){
                availableDates[k-2][1] = theDate + " - Night";
                System.out.println(k + availableDates[k-2][1]);
                k++;
                }
        }
        System.out.println("please input one of these times to reserve");
         while(true){
            String choice = input.nextLine();
            if (Integer.parseInt(choice) > k || Integer.parseInt(choice) < 0){
                System.out.println("please choose somthing in range");
                continue;
            }        
        System.out.println("please enter 1 for morning and 2 for night reservation");
        boolean continueInput =true;
        do{
            String MorOrNigh = input.nextLine();
                switch(MorOrNigh){
                    case "0" : 
                        m = 0; 
                        continueInput = false;
                        break;
                    case "1" : 
                        m=1;
                        continueInput = false;
                        break;
                    default: 
                        System.out.println("proper input must be either 1 or 2");
                        break;
                }
        }while(continueInput);
              String theTime = availableDates[k][m];
            return theTime;
        }

    }
}