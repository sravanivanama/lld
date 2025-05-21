package service;

import model.*;

public class AccountLoader {
    public Account getAccountById(String accId){
        // SQL Query to get the account details from DB
        String sqlQuery = String.format("select * from DB.Accounts where accId = %s", accId);
        Account acc = new Account("4567", new User("sravs", "vanama", "female", "765643", "bdhgvhg"));
        return acc;
    }


}
