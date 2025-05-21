package model;

public class Wallet {
    double balance;
    Account account;

    public Wallet(double balance, Account account) {
        this.balance = balance;
        this.account = account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
