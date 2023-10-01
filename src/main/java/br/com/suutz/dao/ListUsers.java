package br.com.suutz.dao;

import br.com.suutz.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUsers {

    public List<User> findAllUsers(){

        String SQL = "SELECT * FROM USUARIO";

        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Connection succsess");

            PreparedStatement preparedStatement =  connection.prepareCall(SQL);

            ResultSet resultSet  = preparedStatement.executeQuery();

            List<User> logins = new ArrayList<>();

            while (resultSet.next()){
                String username = resultSet.getString("login");
                String passsword = resultSet.getString("password");

                User user = new User(username, passsword);

                logins.add(user);
            }//while
            System.out.println("Success in select User");
            connection.close();

            return logins;

        }catch (Exception e){
            System.out.println("Connection falied");
        }
        return Collections.emptyList();
    }//ArrayList de logins
}
