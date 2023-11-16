package br.com.suutz.common;

import java.util.ArrayList;

import br.com.suutz.DAO.StocksDAO;
import br.com.suutz.entity.Stock;

public class updateStocksPrice {

     public static void updateStocksPriceFunction(){
        ArrayList<Stock> listOfStocks = new ArrayList<Stock>();

        listOfStocks = StocksDAO.getStocks();

        for(Stock stock : listOfStocks){
            
            StocksDAO.updateStockValue(stock.getID(), utils.returnNewPrice(stock.getPriceStock()));
            
        }
    }
}