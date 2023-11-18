<<<<<<< HEAD
//package br.com.suutz.common;
//
//import java.util.ArrayList;
//
//import br.com.suutz.DAO.StocksDAO;
//import br.com.suutz.entity.Stock;
//import br.com.suutz.entity.StockClient;
//import br.com.suutz.entity.User;
//
//public class ReturnStocksByUser {
//    public static ArrayList<MyAssetsStocksInterface> ReturnStocksByUserFunction(User user){
//
//        ArrayList<MyAssetsStocksInterface> myAssetsStocksInterface = new ArrayList<MyAssetsStocksInterface>();
//
//        ArrayList<StockClient> stockClients = new ArrayList<StockClient>();
//        stockClients = StocksDAO.getStockClientByUserId(user.getId());
//        ArrayList<Stock> listOfStocks = new ArrayList<Stock>();
//        for(StockClient interactive : stockClients){
//        listOfStocks.add(StocksDAO.getStockById(interactive.getStockId()));
//        }
//        System.out.println("teste");
//    }
//}
=======
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
                double priceMedium = 0;

                for(Stock interactive2 : listOfStocks){
                if(interactive.getNameStock().equalsIgnoreCase(interactive2.getNameStock())){
                    priceMedium += interactive2.getPriceStock();
                    accounter++;
                    }
                }
                MyAssetsStocksInterface myAssets = new MyAssetsStocksInterface();
                myAssets.setNameStock(interactive.getNameStock());
                myAssets.setPriceNow(interactive.getPriceStock());
                myAssets.setPricePay((priceMedium/accounter));
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
>>>>>>> 3829be2cbea7947342d20c2d044a5a51e89c325d
