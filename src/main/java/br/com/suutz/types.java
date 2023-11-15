package br.com.suutz;

public class types {

public interface UserInterface {
    int id();
    String login();
    String senha();
    double balance();
}

public interface StockInterface {
    int id();
    String name_stock();
    double price_stock();
}

public interface StockClientInterface {
    int id();
    int user_id();
    int stock_id();
    int qtd();
}

public interface FixedIncomeInterface {
    int id();
    double price();
    String name();
    String type();
    double fee();
}

public interface FixedIncomeClientInterface {
    int id();
    int user_id();
    int fixed_income_id();
    double amount();
    double yeld();
}

}