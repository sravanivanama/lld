package model;

public class Account {
    String accId;
    User user;

    public Account(String accId, User user) {
        this.accId = accId;
        this.user = user;
    }
}
