public class Wallet {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Wallet() {
        balance = 0;
    }

    public Wallet(int balance) {
        this.balance = balance;
    }

    public void pay(Event event) {
        if (event != null && event.getOrganizer() != null) {
            balance -= event.getCost();
            event.getOrganizer().setBalance(event.getOrganizer().getBalance() + event.getCost());
            event.setAttendeeNum(event.getAttendeeNum() + 1); // Fixed method name
        }
    }


    public void addMoney(double amount) {
        balance += amount;
    }

    public void withdrawMoney(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
        }
    }
}