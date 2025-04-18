import java.util.ArrayList;


public class Database {
    static int intialCapacity = 1000;
    public static ArrayList<Person> people = new ArrayList<>(intialCapacity);
    public static ArrayList<Event> events = new ArrayList<>(intialCapacity);
    public static ArrayList<Room> rooms = new ArrayList<>(intialCapacity);
    public static ArrayList<Categories> categories = new ArrayList<>(intialCapacity);
}
