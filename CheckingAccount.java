//CheckingAccount Class

public class CheckingAccount extends Account {

    // methods
    public void withdraw(double amount) throws NoSufficientFundsException {

        // if amount > 0 and amount <= balance
        if (getBalance() > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
        } else {
            throw new NoSufficientFundsException();
        }
    }

    public String toString() {
        return "Checking " + super.toString();
    }

}