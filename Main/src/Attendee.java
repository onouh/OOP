import java.util.ArrayList;
import java.util.Date;

public class Attendee extends Person {
    private String address;
    private Wallet wallet;
    private Gender gender;
    private ArrayList<String> interests;

    
    Attendee(){

    }
    Attendee(Date dob, Wallet wallet, Gender gender, String address, ArrayList<String> interests, String username,String password, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        super(username, password, yearOfBirth, monthOfBirth, dayOfBirth);
        this.loggedIn = false;
        this.wallet = wallet;
        this.address = address;
        this.gender = gender;
        this.interests = interests;
    }

    public String getAddress() {
        return address;
    }
    public Gender getGender() {
        return gender;
    }
    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public void buy(Ticket ticket){
        if (this.wallet.getBalance() >= ticket.getTicketPrice()){
            this.wallet.setBalance(this.wallet.getBalance() - ticket.getTicketPrice());
            System.out.println("Ticket bought successfully");
        } else {
            System.out.println("Not enough balance");
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }
    @Override
    protected void homeScreen() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'homeScreen'");
    }
}
