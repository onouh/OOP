import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;
import java.time.LocalDate;

public class Organizer extends Person implements Employee<Event> {

    private Wallet wallet;
    Scanner input= new Scanner(System.in);
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
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
    public void create(){
        Categories myCat ;
        Room myRoom;
        int k = 0;
        for(Categories c: Database.categories){
            System.out.println(k + c.getName());
            k++;
        }
        System.out.println("please choose the category");
        while(true){
            String choice = input.nextLine();
            if (Integer.parseInt(choice) > Database.categories.size() || Integer.parseInt(choice) < 0){
                System.out.println("please choose somthing in range");
                continue;
            }
            myCat = Database.categories.get(Integer.parseInt(choice));
            break;
        }
        System.out.println("please enter the name of the event");
        String name = input.nextLine();
        int price = Integer.parseInt(input.nextLine());
        int t = 0;    
        for(Room r: Database.rooms){
            System.out.println(t + r.getRoomNo());
            t++;
        }
        System.out.println("please choose a room");
        while(true){
            String choice = input.nextLine();
            if (Integer.parseInt(choice) > Database.rooms.size() || Integer.parseInt(choice) < 0 ){
                System.out.println("please choose somthing in range");
                continue;
            }
            int index = -1;
            for (int i = 0; i < Database.rooms.size(); i++) {
                if (Database.rooms.get(i).getRoomNo() == Integer.parseInt(choice)) {
                    index = i;
                    break;
                }
            }
            myRoom = Database.rooms.get(index);
            break;
        }
        String myTime = myRoom.chooseAvalableTimes();
        String calvalue = myTime.substring(0,11);
        String State = myTime.substring(14,myTime.length());
        LocalDate date = LocalDate.parse(calvalue, format);
        Calendar cal = Calendar.getInstance();
        cal.set(date.getYear(),date.getMonthValue()-1,date.getDayOfMonth());
        Reservations res = new Reservations();
        res.reserve(myRoom, cal, State);
        Database.events.add(new Event(name,myCat,price,cal,myRoom));    
    }
    
    @Override
    public void read(Event e){
        System.out.println(e.toString);
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
