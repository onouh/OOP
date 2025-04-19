import java.util.ArrayList;
import java.util.Date;

public class Attendee extends Person {
    String address;
    Date dob;
    Wallet wallet;
    Gender gender;
    ArrayList<String> interests;

    
    Attendee(){

    }
    Attendee(Date dob, Wallet wallet, Gender gender, String address, ArrayList<String> interests, String username,String password){
        super(username,password);
        this.username = username;
        this.password = password;
        this.loggedIn = false;
        this.dob = dob;
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
    public void buy(Ticket ticket){
        if (this.wallet.getBalance() >= ticket.getPrice()){
            this.wallet.setBalance(this.wallet.getBalance() - ticket.getPrice());
            System.out.println("Ticket bought successfully");
        }else{
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
