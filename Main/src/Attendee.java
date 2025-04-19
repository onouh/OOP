import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Attendee extends Person {
    private String address;
    private Wallet wallet;
    private Gender gender;
    private ArrayList<String> interests;

    
    Attendee(){

    }
    Attendee(Date dob, Wallet wallet, Gender gender, String address, ArrayList<String> interests, String username,String password, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        super(username, password, yearOfBirth, monthOfBirth, dayOfBirth);
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
        return "Attendee{" +
                "address='" + address + '\'' +
                ", wallet=" + wallet +
                ", gender=" + gender +
                ", interests=" + interests +
                '}';
    }
    @Override
    protected void homeScreen() {
        input = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Welcome, " + this.getUsername() + "!");
                System.out.println("What would you like to do?");
                System.out.println("1- View Profile");
                System.out.println("2- View Wallet Balance");
                System.out.println("3- Buy a Ticket");
                System.out.println("4- View Interests");
                System.out.println("5- Log Out");

                String choice = input.nextLine();

                switch (choice) {
                    case "1" -> System.out.println(this.toString());
                    case "2" -> System.out.println("Wallet Balance: " + this.wallet.getBalance());
                    case "3" -> {
                        System.out.println("Enter ticket details:");
                        System.out.println("Enter ticket ID:");
                        String ticketID = input.nextLine();
                        System.out.println("Enter event name:");
                        String eventName = input.nextLine();
                        System.out.println("Enter event date:");
                        String eventDate = input.nextLine();
                        System.out.println("Enter event time:");
                        String eventTime = input.nextLine();
                        System.out.println("Enter event location:");
                        String eventLocation = input.nextLine();
                        System.out.println("Enter ticket price:");
                        double ticketPrice = input.nextDouble();
                        input.nextLine(); // Consume newline
                        Ticket ticket = new Ticket(ticketID, eventName, eventDate, eventTime, eventLocation, ticketPrice);
                        this.buy(ticket);
                    }
                    case "4" -> {
                        System.out.println("Your Interests:");
                        for (String interest : this.interests) {
                            System.out.println("- " + interest);
                        }
                    }
                    case "5" -> {
                        System.out.println("Logging out...");
                        break;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }

                if (choice.equals("5")) {
                    this.loggedIn = false;
                    System.out.println("You have logged out successfully.");
                    break;
                }
            }
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
}
