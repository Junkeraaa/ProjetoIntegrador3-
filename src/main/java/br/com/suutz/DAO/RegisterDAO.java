package br.com.suutz.DAO;

import br.com.suutz.entity.User;

import java.sql.*;


public class RegisterDAO {




    public static int registerUserDAO(User user) {
        String SQLCheckUser = "SELECT COUNT(*) FROM USUARIOS WHERE login=?";
        String SQLInsertUser = "INSERT INTO USUARIOS (login, senha, balance) VALUES (?, ?, 0)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement checkUserStatement = connection.prepareStatement(SQLCheckUser);
            checkUserStatement.setString(1, user.getUser());
            ResultSet resultSet = checkUserStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            // User already exists (return int 1)
            if (count > 0) {
                System.out.println("User already exists. Registration failed.");
                connection.close();
                return 1;
            }


            // Verify if password has less than 6 caracteres (return int 2)
            if (user.getPassword().length() < 6) {
                System.out.println("Password must have at least 6 characters. Registration failed.");
                connection.close();
                return 2;
            }

            // User not registred and the password has more than 6 caracteres, successfully registered (return int 0)
            PreparedStatement preparedStatement = connection.prepareStatement(SQLInsertUser);
            preparedStatement.setString(1, user.getUser());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.execute();

            System.out.println("Successfully registered");
            connection.close();

            return 0;
        } catch (Exception e) {
            // Connection falied (return int 3)

            System.out.println("Connection failed");
            return 3;
        }
    }

}




