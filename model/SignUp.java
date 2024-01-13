package com.example.ucsm.studentrecordmanagement.model;

/**
 * Created by UCSM on 10/26/2016.
 */

public class SignUp {
    int signUpId;
    String signUpName;
    String signUpPassword;
    String backup;

    public SignUp(int signUpId, String signUpName, String signUpPassword,String backup) {
        this.signUpId = signUpId;
        this.signUpName = signUpName;
        this.signUpPassword = signUpPassword;
        this.backup=backup;
    }

    public SignUp() {
    }

    public SignUp(String signUpName, String signUpPassword) {
        this.signUpName = signUpName;
        this.signUpPassword = signUpPassword;
    }

    public SignUp(int signUpId, String signUpName, String signUpPassword) {
        this.signUpId = signUpId;
        this.signUpName = signUpName;
        this.signUpPassword = signUpPassword;
    }

    public String getBackup(){return backup;}
    public void setBackup(String backup){this.backup=backup;}
    public int getSignUpId() {
        return signUpId;
    }

    public void setSignUpId(int signUpId) {
        this.signUpId = signUpId;
    }

    public String getSignUpName() {
        return signUpName;
    }

    public void setSignUpName(String signUpName) {
        this.signUpName = signUpName;
    }

    public String getSignUpPassword() {
        return signUpPassword;
    }

    public void setSignUpPassword(String signUpPassword) {
        this.signUpPassword = signUpPassword;
    }
}
