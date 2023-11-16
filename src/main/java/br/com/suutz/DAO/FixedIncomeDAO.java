package br.com.suutz.DAO;

import java.sql.*;
import java.util.ArrayList;

import br.com.suutz.entity.FixedIncome;

public class FixedIncomeDAO {

    public static FixedIncome getFixedIncomesByName(String incomeName) {
        FixedIncome fixedIncomeSpecific = new FixedIncome();

        String SQLSelectFixedIncome = "SELECT * FROM FIXED_INCOME WHERE name = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Connection Success");

            PreparedStatement fixedIncomeStatement = connection.prepareStatement(SQLSelectFixedIncome);
            fixedIncomeStatement.setString(1, incomeName);
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
    

}//DAO

