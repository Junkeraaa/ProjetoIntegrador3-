package br.com.suutz.DAO;

import java.sql.*;
import java.util.ArrayList;

import br.com.suutz.entity.Stock;

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



   public ArrayList<Stock> getStocks() {
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
