import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
public class App {

    static Scanner input = new Scanner(System.in);
    Attendee attendee  = new Attendee();
    Organizer oragnizer = new Organizer();

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to The EventHub!\n");
        System.out.println("1- Login");
        System.out.println("2- Signup");
                while(true){
            String i = input.nextLine();
            switch(i){
                case "1" -> {
                    Person.LogIn();
                    break;
                }
                case "2" -> {
                    System.out.println("Enter your Username: ");
                    String username = input.nextLine();
                    Person.Checkusername(username);
                    String genderstring;
                    Gender gender;
                    int day,month,year;
                    while(true){
                        System.out.println("Enter your Gender (Male/Female): ");
                        genderstring = input.nextLine().toLowerCase();
                        switch(genderstring){
                            case "male" -> {
                                gender = Gender.MALE;
                                break;
                            }
                            case "female" ->{
                                gender = Gender.FEMALE;
                                break;
                            }
                            default ->{
                                System.out.println("Invalid Input. Try again");
                                continue;
                            }


                        }
                        break;
                    }

                    System.out.println("Enter your Address: ");
                    String address = input.nextLine();


                    while(true){

                        System.out.println("Enter your date of birth (DD/MM/YYYY): ");
                        String datestring = input.nextLine();
                        try {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate date = LocalDate.parse(datestring, formatter);
                            day = date.getDayOfMonth();
                            month = date.getMonthValue();
                            year = date.getYear();

                            if (year < 1900 || year > 2100) {
                                System.out.println("Year is out of valid range");
                                continue;
                            }
                            break;

                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format or value: " + e.getMessage());
                        }
                    }
                    System.out.println("Enter your Password: ");
                    String password = input.nextLine();

                    double balance = 0;
                    boolean validInput = false;

                    while (!validInput) {
                        try {
                            System.out.println("Enter Your balance: ");
                            balance = input.nextInt();
                            if(balance >= 0) validInput = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            input.next();
                        }
                    }
                    Wallet wallet = new Wallet(balance);
                    ArrayList<String> interests = new ArrayList<String>(3);
                    System.out.println("Enter 3 interests that reflects your personality: ");
                    for(int j = 0; j < 3; j++) interests.set(j, input.next());


                    Database.people.add(new Attendee(wallet, gender, address, interests ,username, password, day, month, year ));
                    break;
                }
                default -> {
                    System.out.println("Invalid Input. Try again.");
                }
            }

        }


    }
    public static Date parseDate(String dateStr, String format) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat(format);
        dateformat.setLenient(false); // Strict parsing
        return dateformat.parse(dateStr);


}
    }
