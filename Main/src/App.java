import java.util.Date;
import java.util.Scanner;
public class App {

    static Scanner input = new Scanner(System.in);
    Attendee attendee  = new Attendee();
    Organizer oragnizer = new Organizer();

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to The EventHub!\n");
        System.out.println("1- Login");
        System.out.println("2- Signup");
        String i = input.nextLine();
        while(true){
            switch(i){
                case "1" -> {
                    Person.LogIn();
                    break;
                }
                case "2" -> {
                    Database.people.add(new Attendee());
                    break;
                }
                default -> {
                    System.out.println("Invalid Input. Try again.");
                }
            }

        }


    }
}
