package br.com.suutz.common;

import java.util.ArrayList;

import br.com.suutz.DAO.StocksDAO;
import br.com.suutz.entity.Stock;

public class updateStocksPrice {
     public static void updateStocksPriceFunction(){
        ArrayList<Stock> listOfStocks = new ArrayList<Stock>();

        for(Stock stock : listOfStocks){
            
            StocksDao.updateStockValue(stock.getID(), utils.returnNewPrice(stock.getPriceStock()));
            
        }

     }
}