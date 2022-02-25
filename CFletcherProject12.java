import java.util.ArrayList;

/*
 * 
 * This program demonstrates exception handeling
 * 
 * Author: Cheron Fletcher
 * Date: 05/06/21
 */

public class CFletcherProject12 {

    public static void main(String[] args) {

        // initalize accounts 0 & 1 to Checking Accounts
        CheckingAccount checking1 = new CheckingAccount();
        checking1.setId(111);
        checking1.setBalance(10000);

        CheckingAccount checking2 = new CheckingAccount();
        checking2.setId(222);
        checking2.setBalance(12967.57);

        // initalize account 2 & 3 to be Saving Accounts
        SavingAccount saving1 = new SavingAccount();
        saving1.setId(333);
        saving1.setBalance(450.54);
        saving1.setInterestRate(.07);

        SavingAccount saving2 = new SavingAccount();
        saving2.setId(444);
        saving2.setBalance(19034.00);
        saving2.setInterestRate(.19);

        ArrayList<Account> accounts = new ArrayList<>(4);

        accounts.add(checking1);
        accounts.add(checking2);
        accounts.add(saving1);
        accounts.add(saving2);

        // print test
        System.out.println("\nAccount balances begin at:\n");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i));
            System.out.println();
        }
        System.out.println("********************\n");

        // make deposit and withdraw for each account & print out the account info

        // print after deposits
        System.out.println("Deposit $-400.02 into Account 111");
        System.out.println("Deposit $700.45 into Account 222");
        System.out.println("Deposit $1093.40 into Account 333");
        System.out.println("Deposit $20.00 into Account 444");
        System.out.println("\nAfter deposits:\n");

        // id 111
        try {
            checking1.deposit(-400.02);
        } catch (IllegalAmountException ex) {
            System.out.println("Deposit unsucessfull for " + checking1.toString());
            ex.printStackTrace();
            System.out.println();
        }

        // id 222
        try {
            checking2.deposit(700.45);
        } catch (IllegalAmountException ex) {
            System.out.println("Deposit unsucessfull for " + checking2.toString());
            ex.printStackTrace();
            System.out.println();
        }

        // id 333
        try {
            saving1.deposit(1093.4);
        } catch (IllegalAmountException ex) {
            System.out.println("Deposit unsucessfull for " + saving1.toString());
            ex.printStackTrace();
            System.out.println();
        }

        // id 444
        try {
            saving2.deposit(20);
        } catch (IllegalAmountException ex) {
            System.out.println("Deposit unsucessfull for " + saving2.toString());
            ex.printStackTrace();
            System.out.println();
        }

        // print account info after deposit
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i));
            System.out.println();
        }
        System.out.println("********************\n");

        // print after withdrawals
        System.out.println("Withdraw $400.02 from Account 111");
        System.out.println("Withdraw $700.45 from Account 222");
        System.out.println("Withdraw $1093.40 from Account 333");
        System.out.println("Withdraw $20 from Account 444");
        System.out.println("\nAfter withdrawals:\n");

        // id 111
        try {
            checking1.withdraw(400.02);
        } catch (NoSufficientFundsException ex) {
            System.out.println("NSF - not able to withdraw $400.02 from " + checking1.toString());
            ex.printStackTrace();
            System.out.println();
        }

        // id 222
        try {
            checking2.withdraw(700.45);
        } catch (NoSufficientFundsException ex) {
            System.out.println("NSF - not able to withdraw $700.45 from " + checking2.toString());
            ex.printStackTrace();
            System.out.println();
        }

        // id 333
        try {
            saving1.withdraw(1093.4);
        } catch (NoSufficientFundsException ex) {
            System.out.println("NSF - not able to withdraw $1093.40 from " + saving1.toString());
            ex.printStackTrace();
            System.out.println();
        }

        // id 444
        try {
            saving2.withdraw(20);
        } catch (NoSufficientFundsException ex) {
            System.out.println("NSF - not able to withdraw $20.00 from " + saving2.toString());
            ex.printStackTrace();
            System.out.println();
        }

        // print account info after withdrawls
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i));
            System.out.println();
        }
        System.out.println("********************\n");

        // if accout is SavingAccount, call addInterest then print account info

        saving1.addInterest();
        saving2.addInterest();

        // print test
        System.out.println("After addInterest:\n");
        for (int i = 2; i < accounts.size(); i++) {
            System.out.println(accounts.get(i));
            System.out.println();
        }
        System.out.println();

    }
}

/*
 * 
 * Account balances begin at:
 * 
 * Checking Account ID: 111 Balance: $10000.00
 * 
 * Checking Account ID: 222 Balance: $12967.57
 * 
 * Saving Account ID: 333 Balance: $450.54 Interest Rate: 0.07
 * 
 * Saving Account ID: 444 Balance: $19034.00 Interest Rate: 0.19
 ********************
 * 
 * 
 * Deposit $-400.02 into Account 111 Deposit $700.45 into Account 222 Deposit
 * $1093.40 into Account 333 Deposit $20.00 into Account 444
 * 
 * After deposits:
 * 
 * Deposit unsucessfull for Checking Account ID: 111 Balance: $10000.00
 * IllegalAmountException: Illegal Amount: -400.02 at
 * Account.deposit(Account.java:42) at
 * CFletcherProject12.main(CFletcherProject12.java:61)
 * 
 * Checking Account ID: 111 Balance: $10000.00
 * 
 * Checking Account ID: 222 Balance: $13668.02
 * 
 * Saving Account ID: 333 Balance: $1543.94 Interest Rate: 0.07
 * 
 * Saving Account ID: 444 Balance: $19054.00 Interest Rate: 0.19
 ********************
 * 
 * 
 * Withdraw $400.02 from Account 111 Withdraw $700.45 from Account 222 Withdraw
 * $1093.40 from Account 333 Withdraw $20 from Account 444
 * 
 * After withdrawals:
 * 
 * NSF - not able to withdraw $1093.40 from Saving Account ID: 333 Balance:
 * $1543.94 Interest Rate: 0.07 NoSufficientFundsException: Non-Sufficient Funds
 * at SavingAccount.withdraw(SavingAccount.java:26) at
 * CFletcherProject12.main(CFletcherProject12.java:129)
 * 
 * Checking Account ID: 111 Balance: $9599.98
 * 
 * Checking Account ID: 222 Balance: $12967.57
 * 
 * Saving Account ID: 333 Balance: $1543.94 Interest Rate: 0.07
 * 
 * Saving Account ID: 444 Balance: $19034.00 Interest Rate: 0.19
 ********************
 * 
 * 
 * After addInterest:
 * 
 * Saving Account ID: 333 Balance: $1652.02 Interest Rate: 0.07
 * 
 * Saving Account ID: 444 Balance: $22650.46 Interest Rate: 0.19
 * 
 * 
 */