package br.com.suutz.dao;

import br.com.suutz.model.User;

import java.sql.*;


public class RegisterDAO {

    public boolean registerUserDAO(User user) {
        String SQLCheckUser = "SELECT COUNT(*) FROM USUARIOS WHERE login=?";
        String SQLInsertUser = "INSERT INTO USUARIOS (login, senha) VALUES (?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Connection Success");

            PreparedStatement checkUserStatement = connection.prepareStatement(SQLCheckUser);
            checkUserStatement.setString(1, user.getUser());
            ResultSet resultSet = checkUserStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count > 0) {
                // Usuário já existe, não é possível registrar novamente
                System.out.println("User already exists. Registration failed.");
                connection.close();
                return false;
            }


            // Verifique se a senha tem pelo menos 6 caracteres
            if (user.getPassword().length() < 6) {
                System.out.println("Password must have at least 6 characters. Registration failed.");
                connection.close();
                return false;
            }

            // O usuário não existe e a senha tem pelo menos 6 caracteres, pode ser registrado
            PreparedStatement preparedStatement = connection.prepareStatement(SQLInsertUser);
            preparedStatement.setString(1, user.getUser());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.execute();

            System.out.println("Cadastrado com sucesso");
            connection.close();

            return true; // Registro bem-sucedido
        } catch (Exception e) {
            System.out.println("Connection failed");
            return false; // Registro falhou devido a erro de conexão
        }
    }

}




