package br.com.suutz.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.Random;

import br.com.suutz.entity.Stock;

public class StocksDAO {

    public static void updateStockValue(int id, double value){


        String updateValueSQL = "UPDATE STOCKS SET price_stock = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")){

            PreparedStatement updateValueStatement  = connection.prepareStatement(updateValueSQL);

            updateValueStatement.setDouble(1, value);
            updateValueStatement.setInt(2, id);

            int rowsAffected = updateValueStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Balance updated successfully.");
            } else {
                System.out.println("User not found or balance not updated.");
            }//ifelse
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static Stock getStockByName(String stockName) {

        Stock stock = new Stock();

    String SQLSelectStock = "SELECT * FROM STOCKS WHERE name_stock = ?";

    try {
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
        System.out.println("Connection Success");

        PreparedStatement stockStatement = connection.prepareStatement(SQLSelectStock);
        stockStatement.setString(1, stockName);
        ResultSet resultSet = stockStatement.executeQuery();

        if (resultSet.next()) {
        Stock stockSpecific = new Stock();
            stockSpecific.setId(resultSet.getInt("id"));
            stockSpecific.setNameStock(resultSet.getString("name_stock"));
            stockSpecific.setPriceStock(resultSet.getDouble("price_stock"));

            stock = stockSpecific;
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



   public static ArrayList<Stock> getStocks() {
    ArrayList<Stock> stocksList = new ArrayList<>();

    String SQLSelectStock = "SELECT * FROM STOCKS";

    try {
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
        System.out.println("Connection Success");

        PreparedStatement stockStatement = connection.prepareStatement(SQLSelectStock);
        ResultSet resultSet = stockStatement.executeQuery();

        while (resultSet.next()) {
            Stock stockSpecific = new Stock();
            stockSpecific.setId(resultSet.getInt("id"));
            stockSpecific.setNameStock(resultSet.getString("name_stock"));
            stockSpecific.setPriceStock(resultSet.getDouble("price_stock"));

            stocksList.add(stockSpecific);
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
