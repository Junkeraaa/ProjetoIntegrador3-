package br.com.suutz.DAO;

import java.sql.*;

import br.com.suutz.entity.User;

import javax.sound.midi.Soundbank;

public class UsuarioDAO {

    public double selectUserBalance(String username){
        String selectBalance=  "SELECT * FROM USUARIOS WHERE login = ?";
        double userBalance = 0.0;
        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement selectBalanceStatement = connection.prepareStatement(selectBalance);
            selectBalanceStatement.setString(1, username);
            ResultSet resultSet = selectBalanceStatement.executeQuery();

            if(resultSet.next()){
                userBalance = resultSet.getDouble("balance");

                System.out.println("Balance:" + userBalance);
            }


        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        return userBalance;
    }






    public void updateBalance(String username, double newBalance) {
        // Em seguida, faça a atualização com o ID do usuário
        String updateBalanceSQL = "UPDATE USUARIOS SET balance = ? WHERE login = ?";



        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")) {

            PreparedStatement updateBalanceStatement = connection.prepareStatement(updateBalanceSQL);
            updateBalanceStatement.setDouble(1, newBalance);
            updateBalanceStatement.setString(2, username);

            int rowsAffected = updateBalanceStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Balance updated successfully.");
            } else {
                System.out.println("User not found or balance not updated.");
            }//ifelse
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }//cachj
    }//updateBalance



}//userDAO
