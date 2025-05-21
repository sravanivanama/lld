package model;

import enums.TransactionType;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    // debit or credit -> can be made ENUM
    TransactionType transactionType;
    double amount;
    Account fromAccount;
    Account toAccount;
    String remarks;
    long transactionTimestamp;

    public Transaction(TransactionType transactionType, double amount, Account fromAccount,Account toAccount, String remarks, long transactionTimestamp) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.remarks = remarks;
        this.transactionTimestamp = transactionTimestamp;
    }



    public double getAmount() {
        return amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public long getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public void setTransactionTimestamp(long transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
    }

    // constructors

    // all the setters and getters

}
