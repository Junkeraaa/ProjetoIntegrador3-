import java.sql.*;
import java.util.ArrayList;

public class FixedIncomeDAO {

    public FixedIncome getIncomesByName(String incomeName) {
        FixedIncome fixedIncome = new FixedIncome();

        String SQLSelectFixedIncome = "SELECT * FROM FIXED_INCOME WHERE name = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Connection Success");

            PreparedStatement fixedIncomeStatement = connection.prepareStatement(SQLSelectFixedIncome);
            fixedIncomeStatement.setString(1, incomeName);
            ResultSet resultSet = fixedIncomeStatement.executeQuery();

            if (resultSet.next()) {
                fixedIncome = new FixedIncome(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getBigDecimal("price"),
                        resultSet.getString("type"),
                        resultSet.getBigDecimal("fee")
                );
            }

            resultSet.close();
            fixedIncomeStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        return fixedIncome;
    }//getIncomesByName
    


public ArrayList<FixedIncome> getIncomes() {
    ArrayList<FixedIncome> fixedIncomeList = new ArrayList<>();

    String SQLSelectFixedIncome = "SELECT * FROM FIXED_INCOME";

    try {
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
        System.out.println("Connection Success");

        PreparedStatement fixedIncomeStatement = connection.prepareStatement(SQLSelectFixedIncome);
        ResultSet resultSet = fixedIncomeStatement.executeQuery();

        while (resultSet.next()) {
            FixedIncome fixedIncome = new FixedIncome(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getBigDecimal("price"),
                    resultSet.getString("type"),
                    resultSet.getBigDecimal("fee")
            );

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

