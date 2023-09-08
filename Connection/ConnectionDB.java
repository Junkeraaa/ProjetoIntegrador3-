package Connection; // package of ConnectionDB.

import java.sql.Connection;
import java.sql.DriverManager;  // imports of used libraries.
import java.sql.SQLException;

public class ConnectionDB { // criation of class ConnectionDB.

    private static final String url = "jdbc:mysql://localhost:3306/SuutzInvestments"; // url of used database.
    private static final String user = "root";  // user of the database.
    private static final String password = "lucas0715";  // password of database.

    private static Connection conn;  // conn is the connection to the database, it is static to be able to use it in all code without instantiation problems.

    public static Connection getConnectionDB(){ // method returns database connection.

        try { // try-catch opening
            if(conn == null){ // if to see if the connection was already open or not.
                conn = DriverManager.getConnection(url, user, password); // If the connection is not open here it creates the connection and returns it.
                return conn;
            } else {
                return conn; // If the connection is already open then just returns it.
            }
        } catch (SQLException e) {
            e.printStackTrace(); // The printStackTrace() method prints information about errors and exceptions to the console. It is useful for debugging and identifying the source of the error in the code.
            return null;
        }
    }
}