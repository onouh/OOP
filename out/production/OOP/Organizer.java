package com.example.app_gui;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Iterator;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Organizer extends Person implements Employee<Event>{ 

    String texterr = "-fx-font-family:'Century Gothic'; -fx-font-size : 16;-fx-text-fill: #FF0000; ";
    private Wallet wallet;
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    ArrayList<Event> mine = new ArrayList<>(1000);

    Organizer(){
        super(null,null,0,0,0);
    
    }
    
    Organizer( String username, String password, int yearOfBirth, int monthOfBirth, int dayOfBirth , int balance) {
        super(username, password, yearOfBirth, monthOfBirth, dayOfBirth);
        this.wallet = new Wallet(balance);
    }

    public double getBalance() {
        return (wallet != null) ? wallet.getBalance() : 0;
    }

    @Override
    public void create(String jack, VBox john) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
    public void create(String name , Categories myCat ,Room myRoom, String price,LocalDate occupation,String State,VBox pwPrice){        
        boolean valid = true;
        if(!(price.matches("\\d+")) || !((Integer.valueOf(price)>0)) ){ 
        Label errormsg1 = new Label ("price must be a positive number");
        errormsg1.setStyle(texterr);
        pwPrice.getChildren().add(errormsg1);
        valid = false;
        }
        
        Calendar cal = GregorianCalendar.from(
            occupation.atStartOfDay(ZoneId.systemDefault())
        );
        
        if(valid){
        Reservations res = new Reservations();
        this.wallet.pay(this, myRoom);
        Event eve = new Event(name,myCat,Integer.parseInt(price),cal,myRoom,this,State);
        Database.events.add(eve);    
        mine.add(eve);
        }
    }
    
    
    public String read(Event e){
        System.out.println(e.toString());
        return "kill me";
    }
    
   
    public void delete(Event e){
        
    Iterator<Reservations> iterator = e.getRoom().getUnavailableDates().iterator();
    while (iterator.hasNext()) {
        Reservations r = iterator.next();
        if (r.getBelonging().equals(e)) {
            iterator.remove(); 
        }
    }
        int index;
        index = Database.events.indexOf(e);
        Database.events.remove(index);
        mine.remove(e);
    }
    
    
    public void update(Event o, String newValue , VBox theInputOfTheNewValue,VBox theInputOfTheCategory){
        for(Event e : Database.events){
            if(o == e){
                o.setName(newValue);
                break;
            }
        }
    }
    
    @Override
    public String toString() {
        return "Organizer{" +
                "Name='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ",balance ='" + wallet.getBalance() + '\'' +
                '}';
    }
    
    public void show(){
        ArrayList<String> attendees = new ArrayList<>(1000); //represents his attnedees
        ArrayList<String> myEvents = new ArrayList<>(1000);
        ArrayList<String> AvRooms = new ArrayList<>(1000);
        for(Event e:Database.events){
            if(e.getOrganizer().getUsername().equals(this.getUsername())){
                myEvents.add(e.getName());
                for (Attendee a:e.getAttendee() ){
                attendees.add(a.getUsername());
                }
            }
        }
        Calendar cal = Calendar.getInstance();
        String formattedDate;
      while (true){

        Instant instant = cal.toInstant();
        LocalDate date = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        formattedDate = date.format(format);
       LocalDate minDate = LocalDate.now().plusDays(3);
       LocalDate maxDate = LocalDate.now().plusDays(17);
       if(date.isBefore(minDate)||date.isAfter(maxDate)){
           System.out.println("the date must be after 2 days from now and before 18 days");
       }else{
       break;
       }
      }
       for(Room r : Database.rooms){
        String [][] avM = r.getAvailableRooms();
           boolean AV = false;
            for(int i = 0; i<15; i++ ){
                int indStartA= (avM[i][0].indexOf('-')+2);
                int indStartb= (avM[i][1].indexOf('-')+2);
               
                String StateA = avM[i][0].substring(indStartA,avM[i][0].length());
                String StateB = avM[i][1].substring(indStartb,avM[i][1].length());
                int beginIndex = 0, endIndex = 10;

                if(!StateA.equals("occupied")){
                    String theDateA = avM[i][0].substring(beginIndex, endIndex);
                    if(theDateA.equals(cal)){
                    AV = true;
                    break;
                }
                }
                if(!StateB.equals("occupied")){
                    String theDateB = avM[i][1].substring(beginIndex, endIndex);
                    if(theDateB.equals(formattedDate)){
                    AV = true;
                    break;
                    }
                }

            }
            if (AV){
                AvRooms.add(String.valueOf(r.getRoomNo()));
            }
        }
        
       
        int max1 = Math.max(attendees.size(),myEvents.size());
        int max  = Math.max(AvRooms.size(), max1);
         System.out.printf("%-20s %-20s %-20s %n", "Free rooms","events","attendees" );
        for(int i = 0 ; i < max ; i++){
        
            String room = (i<AvRooms.size()? AvRooms.get(i) : "");
            String event = (i<myEvents.size()? myEvents.get(i) : "");
            String attendee = (i<attendees.size()? attendees.get(i) : "");
            System.out.printf("%-20s %-20s %-20s %n", "Room no."+room,event,attendee );
        } 
    }
    
    public Wallet getWallet(){
    return this.wallet;
    }
}
    
   
