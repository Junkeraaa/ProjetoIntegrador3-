package br.com.suutz.servlet;

import br.com.suutz.DAO.StocksDAO;
import br.com.suutz.entity.Stock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/getStocks")
public class StocksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Stock> stocksList = StocksDAO.getStocks();


        req.setAttribute("stocksList", stocksList);

        req.getRequestDispatcher("/LoggedInPages/Stocks/stocks.jsp").forward(req, resp);

    }

}
