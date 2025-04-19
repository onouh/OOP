public class Wallet {

    private int balance;




    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Wallet(){
        balance = 0;
    }

    public Wallet(int balance) {
        this.balance = balance;
    }

    void pay(Event event) {

        balance -= event.getRoomCost();
        event.getOrganizer().setBalance(event.getOrganizer().getBalance() + event.getRoomCost());
        event.setattendeenum(event.getattendeenum()++);
    }

    void pay(Organizer organizer) {
        balance -= organizer.getWalletbalance();
        organizer.setWalletbalance(organizer.getWalletbalance() + organizer.getWalletbalance());
    }
    void pay(Attendee attendee) {
        balance -= attendee.getWalletbalance();
        attendee.setWalletbalance(attendee.getWalletbalance() + attendee.getWalletbalance());
    }
    void pay(Categories categories) {
        balance -= categories.getPrice();
        categories.setPrice(categories.getPrice() + categories.getPrice());
    }
    void pay(Room room) {
        balance -= room.getRoomcost();
        room.setRoomcost(room.getRoomcost() + room.getRoomcost());
    }
    void addmoney(int amount) {
        balance += amount;
    }

    void withdrawmoney(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
        }
    }
}