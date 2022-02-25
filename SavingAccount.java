//SavingAccount Class

public class SavingAccount extends Account {
    // variables
    private double interestRate;

    // setters
    public void setInterestRate(double rate) {
        this.interestRate = rate;
    }

    // getters
    public double getInterestRate() {
        return interestRate;
    }

    // methods
    public void withdraw(double amount) throws NoSufficientFundsException {
        // check balance with getter, if ok withdraw
        // min balance must be $500 at all times
        // and withdraw amount > 0

        if (amount > 0 && getBalance() - amount >= 500) {
            setBalance(getBalance() - amount);
        } else {
            throw new NoSufficientFundsException();
        }
    }

    public void addInterest() {
        setBalance(getBalance() * (1 + interestRate));

    }

    public String toString() {
        return "Saving " + super.toString() + "\nInterest Rate: " + interestRate;
        // return String.format("%.2f")
    }

}