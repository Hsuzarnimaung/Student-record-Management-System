package com.example.ucsm.studentrecordmanagement.model;

/**
 * Created by UCSM on 10/21/2016.
 */

public class Account  {

    int userID;
    String userName;
    String passWord;
    public Account(){}


    public Account(int userID, String userName, String passWord) {
        this.userID = userID;
        this.userName = userName;
        this.passWord = passWord;

    }

  /*  public Account(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }*/


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
