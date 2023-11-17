package br.com.suutz.DAO;

import java.sql.*;
import java.util.ArrayList;

import br.com.suutz.entity.Stock;
import br.com.suutz.entity.StockClient;

public class StocksDAO {


    private static void newStockOrder(String username){

        String getUsernameSQL = "SELECT * FROM USUARIOS WHERE login = ?";
        double getUserBalance = 0.0;
        double getStockPrice = 0.0;

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement userStatement = connection.prepareStatement(getUsernameSQL);
            userStatement.setString(1, "login");
            ResultSet resultSet = userStatement.executeQuery();

            if(resultSet.next()){
                //localizou usuario

                username = resultSet.getString("login");
                getUserBalance = UsuarioDAO.selectUserBalance(username);
                getStockPrice = getStockPrice(getStockId(username));

               boolean hasBalance = getUserBalance > getStockPrice;

               if(hasBalance){

                    //insert

               }


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }//newOrder

    private static void insertStockToUser(){

        String insertStockSQL = "INSERT INTO STOCKS_CLIENT (user_id,stock_id) VALUES =(?, ?)";

        

    }




    private static int getStockId(String stockName) {

        String getStockIdSQL = "SELECT * FROM STOCKS WHERE name_stock = ?";
        int stockId = 0;

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement stockIdStatement = connection.prepareStatement(getStockIdSQL);
            stockIdStatement.setString(1, stockName);
            ResultSet resultSet = stockIdStatement.executeQuery();

            if (resultSet.next()) {
                stockId = resultSet.getInt("name_stock");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stockId;
    }



    private static double getStockPrice(int stockID){

        String selectPriceSQL = "SELECT * FROM STOCKS WHERE id = ?";
        double price = 0.0;

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement selectPriceStatement = connection.prepareStatement(selectPriceSQL);
            selectPriceStatement.setInt(1, stockID);
            ResultSet resultSet = selectPriceStatement.executeQuery();

            if(resultSet.next()){

                price = resultSet.getDouble("price_stock");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }//catch


        return price;
    }
    public static void updateStockValue(int id, double value){


        String updateValueSQL = "UPDATE STOCKS SET price_stock = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")){

            PreparedStatement updateValueStatement  = connection.prepareStatement(updateValueSQL);

            updateValueStatement.setDouble(1, value);
            updateValueStatement.setInt(2, id);

            int rowsAffected = updateValueStatement.executeUpdate();

        
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static Stock getStockById(int id) {

        Stock stock = new Stock();

    String SQLSelectStock = "SELECT * FROM STOCKS WHERE id = ?";

    try {
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
        System.out.println("Connection Success");

        PreparedStatement stockStatement = connection.prepareStatement(SQLSelectStock);
        stockStatement.setInt(1, id);
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

    public static ArrayList<StockClient> getStockClientByUserId(int userId) {

        ArrayList<StockClient> stockClient = new ArrayList<StockClient>();

    String SQLSelectStock = "SELECT * FROM STOCKS_CLIENT WHERE user_id = ?";

    try {
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
        System.out.println("Connection Success");

        PreparedStatement stockStatement = connection.prepareStatement(SQLSelectStock);
        stockStatement.setInt(1, userId);
        ResultSet resultSet = stockStatement.executeQuery();

        while (resultSet.next()) {
        StockClient stockSpecificClient = new StockClient();
            stockSpecificClient.setId(resultSet.getInt("id"));
            stockSpecificClient.setUserId(resultSet.getInt("user_id"));
            stockSpecificClient.setStockId(resultSet.getInt("stock_id"));
            stockSpecificClient.setQtd(resultSet.getInt("qtd"));
            stockSpecificClient.setPricePay(resultSet.getDouble("price_pay"));

            stockClient.add(stockSpecificClient);
        }

        resultSet.close();
        stockStatement.close();
        connection.close();
    } catch (SQLException e) {
        System.out.println("Connection Failed");
        e.printStackTrace();
    }

    return stockClient;
}

}
