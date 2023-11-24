package br.com.suutz.DAO;

import java.sql.*;
import java.util.ArrayList;

import br.com.suutz.common.GlobalData;
import br.com.suutz.common.UpdateIncomeUser;
import br.com.suutz.entity.FixedIncome;
import br.com.suutz.entity.FixedIncomeClient;
import br.com.suutz.entity.Stock;

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

                    double difference = getUserBalance - getIncomePrice(incomeId);


                    UsuarioDAO.updateBalance(username,difference);

                    insetIncomeToUser(userId,incomeId,difference, FixedIncomeDAO.getFee());


                    return Math.round(difference*100.0) * 100.0;
                }


            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }


            return 0;

    }


    private static void insetIncomeToUser(int userID, int fixed_income_id, double amount, double yeld){
        String insertIncomeSQL = "INSERT INTO FIXED_INCOME_CLIENT (user_id, fixed_income_id, amount, yield) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement insertStockStatement = connection.prepareStatement(insertIncomeSQL, Statement.RETURN_GENERATED_KEYS);
            insertStockStatement.setInt(1, userID);
            insertStockStatement.setInt(2, fixed_income_id);
            insertStockStatement.setDouble(3, amount);
            insertStockStatement.setDouble(4,yeld);

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

    public static double getAmountByUserId(int userId, int fixedIncomeId) {
        String selectAmountSQL = "SELECT amount FROM FIXED_INCOME_CLIENT WHERE user_id = ? AND fixed_income_id = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
             PreparedStatement selectAmountStatement = connection.prepareStatement(selectAmountSQL)) {

            selectAmountStatement.setInt(1, userId);
            selectAmountStatement.setInt(2, fixedIncomeId);

            try (ResultSet resultSet = selectAmountStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("amount");
                } else {
                    // Lida com o caso em que não há registros correspondentes na tabela FIXED_INCOME_CLIENT
                    return 0.0; // Ou qualquer valor padrão desejado
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static double getFee() {
        String selectFeeSQL = "SELECT fee FROM FIXED_INCOME";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
             PreparedStatement selectFeeStatement = connection.prepareStatement(selectFeeSQL);
             ResultSet resultSet = selectFeeStatement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getDouble("fee");
            } else {
                return 0.0; //Erro
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

