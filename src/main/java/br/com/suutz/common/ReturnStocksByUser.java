package br.com.suutz.common;

import java.util.ArrayList;

import br.com.suutz.DAO.StocksDAO;
import br.com.suutz.entity.Stock;
import br.com.suutz.entity.StockClient;
import br.com.suutz.entity.User;

public class ReturnStocksByUser {
    public static ArrayList<MyAssetsStocksInterface> ReturnStocksByUserFunction(User user){
        
        ArrayList<MyAssetsStocksInterface> myAssetsStocksInterface = new ArrayList<MyAssetsStocksInterface>();

        ArrayList<StockClient> stockClients = new ArrayList<StockClient>();
        stockClients = StocksDAO.getStockClientByUserId(user.getId());
        ArrayList<Stock> listOfStocks = new ArrayList<Stock>();
        for(StockClient interactive : stockClients){
        listOfStocks.add(StocksDAO.getStockById(interactive.getStockId()));
        }
        System.out.println("teste");
    }  
}
