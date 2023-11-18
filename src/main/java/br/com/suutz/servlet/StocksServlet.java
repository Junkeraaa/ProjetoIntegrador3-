package br.com.suutz.servlet;

import br.com.suutz.DAO.StocksDAO;
import br.com.suutz.common.updateStocksPrice;
import br.com.suutz.entity.Stock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@WebServlet("/getStocks")
public class StocksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        ArrayList<Double> stockInitialValues = new ArrayList();
//        ArrayList<Double> stockBalance = new ArrayList();
//
//        stockInitialValues.add(83.2);
//        stockInitialValues.add(1.2);
//        stockInitialValues.add(27.92);
//        stockInitialValues.add(16.33);
//        stockInitialValues.add(51.25);
//        stockInitialValues.add(0.11);
//        stockInitialValues.add(14.16);
//        stockInitialValues.add(2.27);
//        stockInitialValues.add(95.8);
//        stockInitialValues.add(22.22);
//
//
//        for(int i = 0; i < stocksList.size(); i++ ){
//
//
//            double res = stockInitialValues.get(i) - stocksList.get(i).getPriceStock();
//
//
//            double res2 = Math.floor(res * 1000)/100;
//
//            stockBalance.add(res2);
//
//        }
//
//        req.getSession().setAttribute("stockInitialValues", stockInitialValues);


        ArrayList<Stock> stocksList = StocksDAO.getStocks();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        scheduler.scheduleAtFixedRate(() -> {
            updateStocksPrice.updateStocksPriceFunction();
             req.setAttribute("stocksList", stocksList);
        }, 0, 2, TimeUnit.SECONDS);


        req.setAttribute("stocksList", stocksList);

        req.getRequestDispatcher("/LoggedInPages/Stocks/stocks.jsp").forward(req, resp);

    }

}
