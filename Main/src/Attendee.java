import java.util.ArrayList;

public class Attendee extends Person {
    private final String address;
    private final Gender gender;
    private final ArrayList<String> interests;
    private Wallet wallet;
    boolean buysuccess = false;
    boolean logout = false;

    Attendee() {
        this(null, null, null, null, null, null, 0, 0, 0);
    }
    
   
    Attendee(Wallet wallet, Gender gender, String address, ArrayList<String> interests, String username,String password, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
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

    public void buy(Event event){
        if (this.wallet.getBalance() >= event.getTicketPrice()){
            if(event.getAttendeeNum() < event.getRoom().getCapacity()){
                this.wallet.pay(event);
                event.setAttendeeNum(event.getAttendeeNum() + 1);
                System.out.println("Ticket bought successfully");
                event.getAttendee().add(this);
                buysuccess = true;
            }
            else{
                System.out.println("Event number of attendees is complete.");
                System.out.println("Choose another event.");

            }
        }
        else {
            System.out.println("Balance is not sufficient");
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
    public void homeScreen() {
            while (!logout) {
                System.out.println("Welcome, " + this.getUsername() + "!");
                System.out.println("What would you like to do?");
                System.out.println("1- View Profile");
                System.out.println("2- View Wallet Balance");
                System.out.println("3- Buy a Ticket");
                System.out.println("4- Log Out");
                input.nextLine();
                String choice = input.nextLine();

                switch (choice) {
                    case "1" -> System.out.println(this.toString());
                    case "2" -> System.out.println("Wallet Balance: " + this.wallet.getBalance());
                    case "3" -> {

                        while(!buysuccess){
                            for( int i=0; i < Database.events.size(); i++){
                                System.out.print(i+1);
                                System.out.print("- ");
                                System.out.print(Database.events.get(i).toString());

                            }
                            System.out.println("Enter event number:");
                            input.nextLine();
                            int eventNum = input.nextInt();
                            this.buy(Database.events.get(eventNum));

                        }
                    }

                    case "4" -> {
                        System.out.println("Logging out...");
                        this.loggedIn = false;
                        System.out.println("You have logged out successfully.");
                        logout = true;
                        App.main(null);
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }

            }

        }


    }

