//Account

public class Account {
    // variables
    private int id;
    private double balance;

    // constructor
    public Account() {
        this(0, 0);
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    // setters
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    // getters
    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    // methods
    public void deposit(double amount) throws IllegalAmountException {
        if (amount > 0) {
            this.balance += amount;
        } else {
            this.toString();
            throw new IllegalAmountException(amount);
        }

    }

    public void withdraw(double amount) throws NoSufficientFundsException {
        // validate imput and balance
        this.balance -= amount;
    }

    public String toString() {
        return "Account ID: " + id + "\n Balance: $" + String.format("%.2f", balance);
    }

}