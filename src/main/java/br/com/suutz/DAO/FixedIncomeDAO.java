package br.com.suutz.DAO;

import java.sql.*;
import java.util.ArrayList;

import br.com.suutz.entity.FixedIncome;
import br.com.suutz.entity.FixedIncomeClient;

public class FixedIncomeDAO {



    public static FixedIncome getFixedIncomesById(int id) {
        FixedIncome fixedIncomeSpecific = new FixedIncome();

        String SQLSelectFixedIncome = "SELECT * FROM FIXED_INCOME WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");


            PreparedStatement fixedIncomeStatement = connection.prepareStatement(SQLSelectFixedIncome);
            fixedIncomeStatement.setInt(1, id);
            ResultSet resultSet = fixedIncomeStatement.executeQuery();

            if (resultSet.next()) {
               FixedIncome fixedIncome = new FixedIncome();

                       fixedIncome.setId(resultSet.getInt("id"));
                        fixedIncome.setName(resultSet.getString("name"));
                        fixedIncome.setPrice(resultSet.getDouble("price"));
                        fixedIncome.setType(resultSet.getString("type"));
                        fixedIncome.setFee(resultSet.getDouble("fee"));
                
                fixedIncomeSpecific = fixedIncome;
            }

            resultSet.close();
            fixedIncomeStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        return fixedIncomeSpecific;
    }//getIncomesByName
    


public static ArrayList<FixedIncome> getIncomes() {
    ArrayList<FixedIncome> fixedIncomeList = new ArrayList<>();

    String SQLSelectFixedIncome = "SELECT * FROM FIXED_INCOME";

    try {
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
        System.out.println("Connection Success");

        PreparedStatement fixedIncomeStatement = connection.prepareStatement(SQLSelectFixedIncome);
        ResultSet resultSet = fixedIncomeStatement.executeQuery();

        while (resultSet.next()) {
            FixedIncome fixedIncome = new FixedIncome();

                       fixedIncome.setId(resultSet.getInt("id"));
                        fixedIncome.setName(resultSet.getString("name"));
                        fixedIncome.setPrice(resultSet.getDouble("price"));
                        fixedIncome.setType(resultSet.getString("type"));
                        fixedIncome.setFee(resultSet.getDouble("fee"));

            fixedIncomeList.add(fixedIncome);
        }

        resultSet.close();
        fixedIncomeStatement.close();
        connection.close();
    } catch (SQLException e) {
        System.out.println("Connection Failed");
        e.printStackTrace();
    }

    return fixedIncomeList;
}//getIncomes
    
public static ArrayList<FixedIncomeClient> getFixedIncomeByUserId(int userId) {

        ArrayList<FixedIncomeClient> fixedIncome = new ArrayList<FixedIncomeClient>();

    String SQLSelectStock = "SELECT * FROM FIXED_INCOME_CLIENT WHERE user_id = ?";

    try {
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
        System.out.println("Connection Success");

        PreparedStatement stockStatement = connection.prepareStatement(SQLSelectStock);
        stockStatement.setInt(1, userId);
        ResultSet resultSet = stockStatement.executeQuery();

        while (resultSet.next()) {
        FixedIncomeClient stockSpecificClient = new FixedIncomeClient();
            stockSpecificClient.setUserId(resultSet.getInt("id"));
            stockSpecificClient.setFixedIncomeId(resultSet.getInt("fixed_income_id"));
            stockSpecificClient.setAmount(resultSet.getDouble("amount"));
            stockSpecificClient.setYield(resultSet.getInt("yield"));

            fixedIncome.add(stockSpecificClient);
        }

        resultSet.close();
        stockStatement.close();
        connection.close();
    } catch (SQLException e) {
        System.out.println("Connection Failed");
        e.printStackTrace();
    }

    return fixedIncome;
}

}//DAO

