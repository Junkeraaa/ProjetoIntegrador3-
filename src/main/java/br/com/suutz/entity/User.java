package br.com.suutz.entity;

public class User {

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    private String user;
    private String password;
    private double balance;

    public String getUser() {
        return user;
    }


    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

