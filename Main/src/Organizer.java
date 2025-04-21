public class Organizer extends Person{

    private Wallet wallet;


    Organizer(){
        super(null, null, 0, 0, 0);
        this.wallet = new Wallet(0);
    }

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

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
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
    public void homeScreen() {

    }
    
}
