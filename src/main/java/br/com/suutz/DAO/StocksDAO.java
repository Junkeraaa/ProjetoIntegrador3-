import java.sql.*;
import java.util.ArrayList;

public class StocksDAO {

    public Stock getStockByName(String stockName) {

    Stock stock = new Stock();

    String SQLSelectStock = "SELECT * FROM STOCKS WHERE name_stock = ?";

    try {
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
        System.out.println("Connection Success");

        PreparedStatement stockStatement = connection.prepareStatement(SQLSelectStock);
        stockStatement.setString(1, stockName);
        ResultSet resultSet = stockStatement.executeQuery();

        if (resultSet.next()) {
            stock = new Stock(
                    resultSet.getInt("id"),
                    resultSet.getString("name_stock"),
                    resultSet.getBigDecimal("price_stock")
            );
        }

        resultSet.close();
        stockStatement.close();
        connection.close();
    } catch (SQLException e) {
        System.out.println("Connection Failed");
        e.printStackTrace();
    }

    return stock;
}



   public ArrayList<Stock> getStocks() {
    ArrayList<Stock> stocksList = new ArrayList<>();

    String SQLSelectStock = "SELECT * FROM STOCKS";

    try {
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
        System.out.println("Connection Success");

        PreparedStatement stockStatement = connection.prepareStatement(SQLSelectStock);
        ResultSet resultSet = stockStatement.executeQuery();

        while (resultSet.next()) {
            Stock stock = new Stock(
                    resultSet.getInt("id"),
                    resultSet.getString("name_stock"),
                    resultSet.getBigDecimal("price_stock")
            );

            stocksList.add(stock);
        }

        resultSet.close();
        stockStatement.close();
        connection.close();
    } catch (SQLException e) {
        System.out.println("Connection Failed");
        e.printStackTrace();
    }

    return stocksList;
}

}
