package br.com.suutz.entity;

public class User {

    private int id;
    private  String user;
    private String password;
    private double balance;

    public int getId() {
        return id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

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

