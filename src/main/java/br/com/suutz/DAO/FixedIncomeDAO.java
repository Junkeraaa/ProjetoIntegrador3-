package br.com.suutz.DAO;

import java.sql.*;
import java.util.ArrayList;

import br.com.suutz.common.GlobalData;
import br.com.suutz.entity.FixedIncome;
import br.com.suutz.entity.FixedIncomeClient;


public class FixedIncomeDAO {


    public static double newOrder(String username, String incomeName) throws SQLException {
        String getUsernameSQL = "SELECT * FROM USUARIOS WHERE login = ?";
        double getUserBalance = 0.0;
        double getIncomePrice = 0.0;

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement userStatement = connection.prepareStatement(getUsernameSQL);

            userStatement.setString(1, username);
            ResultSet resultSet = userStatement.executeQuery();


            if(resultSet.next()){
                username = resultSet.getString("login");
                getUserBalance = UsuarioDAO.selectUserBalance(username);
                getIncomePrice = getIncomePrice(getIncomeId(incomeName));

                boolean hasBalance = getUserBalance >= getIncomePrice;

                if (hasBalance){
                    int userId = GlobalData.userLogged.getId();
                    int incomeId = getIncomeId(incomeName);

                    double newBalance = getUserBalance - getIncomePrice(incomeId);


                    UsuarioDAO.updateBalance(username,newBalance);

                    insetIncomeToUser(userId,incomeId);


                    return newBalance;
                }else {
                    System.out.println("No balance");
                }

            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return 0;

    }


    private static void insetIncomeToUser(int userID, int fixed_income_id){
        String insertIncomeSQL = "INSERT INTO FIXED_INCOME_CLIENT (user_id, fixed_income_id) VALUES (?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement insertStockStatement = connection.prepareStatement(insertIncomeSQL, Statement.RETURN_GENERATED_KEYS);
            insertStockStatement.setInt(1, userID);
            insertStockStatement.setInt(2, fixed_income_id);

            int rowsAffected = insertStockStatement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = insertStockStatement.getGeneratedKeys();

                if (generatedKeys.next()) {
                    int generatedIncomeId = generatedKeys.getInt(1);
                    connection.close();

                    getIncomeById(generatedIncomeId);

                }
            }

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public static int getIncomeId(String incomeName){

        String getStockIdSQL = "SELECT * FROM FIXED_INCOME WHERE name = ?";
        int incomeId = 0;

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement incomeIdStatement = connection.prepareStatement(getStockIdSQL);
            incomeIdStatement.setString(1, incomeName);
            ResultSet resultSet = incomeIdStatement.executeQuery();

            if(resultSet.next()){

                incomeId = resultSet.getInt("id");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return incomeId;
    }


    public static double getIncomePrice(int incomeId){


        String selectPriceSQL = "SELECT * FROM FIXED_INCOME WHERE id = ?";
        double price = 0.0;

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement getPriceStatement = connection.prepareStatement(selectPriceSQL);
            getPriceStatement.setInt(1, incomeId);
            ResultSet resultSet = getPriceStatement.executeQuery();

            if(resultSet.next()){
                price = resultSet.getDouble("price");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return price;

    }



    public static FixedIncome getIncomeById(int id) {

        FixedIncome fixedIncome = new FixedIncome();

        String SQLSelectIncome = "SELECT * FROM FIXED_INCOME WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");


            PreparedStatement stockStatement = connection.prepareStatement(SQLSelectIncome);
            stockStatement.setInt(1, id);
            ResultSet resultSet = stockStatement.executeQuery();

            if (resultSet.next()) {
                FixedIncome fixedIncomeSpecific = new FixedIncome();
                fixedIncomeSpecific.setId(resultSet.getInt("id"));
                fixedIncomeSpecific.setPrice(resultSet.getDouble("price"));
                fixedIncomeSpecific.setName(resultSet.getString("name"));

                fixedIncome = fixedIncomeSpecific;
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

