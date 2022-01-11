package com.company.model.view;

public class PasswordModel {
    private String pass;
    private String passw2;

    public PasswordModel(String pass, String passw2) {
        this.pass = pass;
        this.passw2 = passw2;
    }

    public PasswordModel() {
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPassw2() {
        return passw2;
    }

    public void setPassw2(String passw2) {
        this.passw2 = passw2;
    }
}
