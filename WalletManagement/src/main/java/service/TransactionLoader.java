package service;

import enums.TransactionType;
import model.Account;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.Transaction;

public class TransactionLoader {

    public List<Transaction> getTransactionHistoryByAmount(String accId){
        Account account = new AccountLoader().getAccountById(accId);

        // get all transactions for a account
        List<Transaction> transactions= new ArrayList<>();
        transactions.sort(new amountComp());
        return transactions;
    }

    public List<Transaction> getTransactionHistoryByDateTime(String accId){
        Account account = new AccountLoader().getAccountById(accId);

        // get all transactions for a account
        List<Transaction> transactions= new ArrayList<>();
        transactions.sort(new TimeComp());
        return transactions;
    }

    public List<Transaction> getAllTransactions(){
        return new ArrayList<>();
    }
    public List<Transaction> filterTransactionsByType(TransactionType type){
        List<Transaction> transactions = getAllTransactions();
        List<Transaction> filteredTransactions = transactions.stream().filter(transaction -> transaction.getTransactionType().equals(type)).collect(Collectors.toList());
        return filteredTransactions;
    }
}
class amountComp implements Comparator<Transaction> {
    @Override
    public int compare(Transaction t1, Transaction t2){
        return Double.compare(t1.getAmount(), t2.getAmount());
    }
}

class TimeComp implements Comparator<Transaction> {
    @Override
    public int compare(Transaction t1, Transaction t2){
        return Long.compare(t1.getTransactionTimestamp(), t2.getTransactionTimestamp());
    }
}
