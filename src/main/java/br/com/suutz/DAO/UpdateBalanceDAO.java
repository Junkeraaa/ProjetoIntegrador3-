    import java.sql.*;
    import java.util.ArrayList;

    import java.sql.*;

import java.sql.*;
import java.math.BigDecimal;

public class UsuarioDAO {

    public void updateBalance(int userId, BigDecimal newBalance) {

        String SQLUpdate = "UPDATE USUARIOS SET balance = ? WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Connection Success");

            PreparedStatement updateUserBalance = connection.prepareStatement(SQLUpdate);
            updateUserBalance.setBigDecimal(1, newBalance);
            updateUserBalance.setInt(2, userId);

            int rowsAffected = updateUserBalance.executeUpdate();//Verificar quandtas linhas foram afetadas dentro do BD

            if (rowsAffected > 0) {
                System.out.println("Balance updated successfully.");
            } else {
                System.out.println("User not found or balance not updated.");
            }//Se foram afetadas + de 0 linhas, foi feito o update

            updateUserBalance.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
    }
}

