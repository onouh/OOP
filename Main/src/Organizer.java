public class Organizer extends Person {
    private final String companyName;
    private final String companyAddress;
    private final String companyPhoneNumber;
    private final String companyEmail;
    private Wallet wallet;

    Organizer(String companyName, String companyAddress, String companyPhoneNumber, String companyEmail, String username, String password) {
        super(username, password);
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPhoneNumber = companyPhoneNumber;
        this.companyEmail = companyEmail;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public double getBalance() {
        return wallet != null ? wallet.getBalance() : 0;
    }

    public void setBalance(double balance) {
        if (wallet != null) {
            wallet.setBalance(balance);
        }
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyPhoneNumber='" + companyPhoneNumber + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                '}';
    }

    @Override
    protected void homeScreen() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'homeScreen'");
    }
    
}
