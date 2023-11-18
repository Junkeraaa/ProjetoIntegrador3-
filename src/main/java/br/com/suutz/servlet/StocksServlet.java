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




        ArrayList<Stock> stocksList = StocksDAO.getStocks();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        scheduler.scheduleAtFixedRate(() -> {
            updateStocksPrice.updateStocksPriceFunction();
             req.setAttribute("stocksList", stocksList);
        }, 0, 2, TimeUnit.SECONDS);


        req.setAttribute("stocksList", stocksList);

        req.getRequestDispatcher("/LoggedInPages/Stocks/stocks.jsp").forward(req, resp);

    }



//    public static void initialValuesStock(){
//
//
//
//
//
//
//    }

}
