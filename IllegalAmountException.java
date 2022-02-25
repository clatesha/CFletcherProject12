public class IllegalAmountException extends Exception {

    public double amount;

    // constructor
    public IllegalAmountException(double amount) {
        super("Illegal Amount: " + amount);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}