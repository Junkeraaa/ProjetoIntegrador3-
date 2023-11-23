package br.com.suutz.DAO;

import br.com.suutz.entity.User;
import br.com.suutz.common.GlobalData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    public static User loginUser(String username, String password) {
        String SQLLoginUser = "SELECT * FROM USUARIOS WHERE login=? AND senha=?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement loginStatement = connection.prepareStatement(SQLLoginUser);
            loginStatement.setString(1, username);
            loginStatement.setString(2, password);
            ResultSet resultSet = loginStatement.executeQuery();

            if (resultSet.next()) {
                // Usuário encontrado, retornar informações do usuário
                System.out.println("Found");

                int dbUserId = resultSet.getInt("id"); 
                String dbUsername = resultSet.getString("login");
                String dbPassword = resultSet.getString("senha");

                User user = new User();
                user.setUser(dbUsername);
                user.setPassword(dbPassword);
                user.setId(dbUserId);
                GlobalData.userLogged = user;

                connection.close();
                return user;
            } else {
                // Usuário não encontrado
                System.out.println("Not Found");
                connection.close();
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar login: " + e.getMessage());
            return null;
        }
    }
}

