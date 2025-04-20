package com.mycompany.curroop;

public class Organizer extends Person implements Employee<Event> {

    private Wallet wallet;

    Organizer( String username, String password, int yearOfBirth, int monthOfBirth, int dayOfBirth , int balance) {
        super(username, password, yearOfBirth, monthOfBirth, dayOfBirth);
        this.wallet = new Wallet(balance);
    }

    public double getBalance() {
        return (wallet != null) ? wallet.getBalance() : 0;
    }

    public void setBalance(double balance) {
        if (wallet != null) {
            wallet.setBalance(balance);
        }
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "Name='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", ='" + wallet.getBalance() + '\'' +
                '}';
    }

    @Override
    protected void homeScreen() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'homeScreen'");
    }
    
}
