public class Organizer extends Person {
    private final String companyName;
    private final String companyAddress;
    private final String companyPhoneNumber;
    private final String companyEmail;

    Organizer(String companyName, String companyAddress, String companyPhoneNumber, String companyEmail, String username, String password) {
        super(username, password);
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPhoneNumber = companyPhoneNumber;
        this.companyEmail = companyEmail;
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
