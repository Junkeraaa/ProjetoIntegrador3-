package br.com.suutz.common;

import java.util.ArrayList;

import br.com.suutz.DAO.StocksDAO;
import br.com.suutz.entity.Stock;
import br.com.suutz.entity.StockClient;
import br.com.suutz.entity.User;

public class ReturnStocksByUser {
    public static ArrayList<MyAssetsStocksInterface> ReturnStocksByUserFunction(User user){
        
        ArrayList<MyAssetsStocksInterface> myAssetsStocksInterface = new ArrayList<MyAssetsStocksInterface>();
        ArrayList<String> stocksCounted = new ArrayList<String>();

        ArrayList<StockClient> stockClients = new ArrayList<StockClient>();
        stockClients = StocksDAO.getStockClientByUserId(user.getId());
        ArrayList<Stock> listOfStocks = new ArrayList<Stock>();
        for(StockClient interactive : stockClients){
        listOfStocks.add(StocksDAO.getStockById(interactive.getStockId()));

        }

        for(Stock interactive : listOfStocks){
            if(existsInStockCounted(interactive.getNameStock(), stocksCounted)){
                stocksCounted.add(interactive.getNameStock());
                int accounter = 0;

                for(Stock interactive2 : listOfStocks){
                if(interactive.getNameStock().equalsIgnoreCase(interactive2.getNameStock())){
                                        ++accounter;
                    }
                }
                double getPricePayedStock = StocksDAO.getPricePayedStock(user.getId(), interactive.getID());
                double priceTotal = getPricePayedStock/accounter;
                double priceNow = interactive.getPriceStock();
                MyAssetsStocksInterface myAssets = new MyAssetsStocksInterface();
                myAssets.setNameStock(interactive.getNameStock());
                myAssets.setPriceNow(priceNow);
                myAssets.setPricePay(priceTotal);
                myAssets.setBalance();
                myAssets.setQtd(accounter);

                myAssetsStocksInterface.add(myAssets);
        }
    }
        return myAssetsStocksInterface;

    } 
    
    public static boolean existsInStockCounted(String stockName, ArrayList<String> stocksCounted){

        boolean exist = true;

        for(String interactive : stocksCounted){
            if(stockName.equalsIgnoreCase(interactive)){
                exist = false;
            }
        }
        return exist;
    }
}

