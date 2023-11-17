package br.com.suutz.common;

import java.util.ArrayList;

import br.com.suutz.DAO.FixedIncomeDAO;
import br.com.suutz.DAO.StocksDAO;
import br.com.suutz.entity.FixedIncome;
import br.com.suutz.entity.FixedIncomeClient;
import br.com.suutz.entity.StockClient;
import br.com.suutz.entity.User;

public class main {
    public static void main(String[] args) {
        
        User teste = new User();
        teste.setId(1);
        teste.setBalance(0);
        teste.setUser("GabrielPuta");
        teste.setPassword("puta123");

        ArrayList<MyAssetsStocksInterface> beleza = new ArrayList<MyAssetsStocksInterface>();
        beleza = ReturnStocksByUser.ReturnStocksByUserFunction(teste);

        for(MyAssetsStocksInterface a : beleza){
            System.out.println(a.getNameStock());
            System.out.println(a.getPriceNow());
            System.out.println(a.getPricePay());
            System.out.println(a.getQtd());
        }
    }
}
