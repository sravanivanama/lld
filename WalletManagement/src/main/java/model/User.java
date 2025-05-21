package model;

public class User{
    String firstName;
    String gender;
    String phoneNumber;
    String lastName;
    String mailId;

    //constructor
    public User(String firstName, String lastName, String gender, String phoneNumber, String mailId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.mailId = mailId;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    //setters and getters

}