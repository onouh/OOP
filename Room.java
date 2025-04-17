package com.mycompany.oopproject;
import java.util.Calendar;


public class Room {

    private static int roomID = 0 ;
    private int roomno;
    private Calendar availableHours;
    private int capacity;
    
    
    
    public Room( Calendar availableHours, int capacity) {
        roomno = roomID;
        roomID++;
        this.availableHours = availableHours;
        this.capacity = capacity;
    }
    
    public int getRoomID() {
        return roomID;
    }
    public Calendar getAvailableHours() {
        return availableHours;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
    public void setAvailableHours(Calendar availableHours) {
        this.availableHours = availableHours;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
