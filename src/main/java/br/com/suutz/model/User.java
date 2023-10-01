package br.com.suutz.model;

public class User {

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    private String user;
    private String password;

    public String getUser() {
        return user;
    }


    public String getPassword() {
        return password;
    }
}

