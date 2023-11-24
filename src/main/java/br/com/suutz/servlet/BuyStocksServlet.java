package br.com.suutz.servlet;

import br.com.suutz.DAO.StocksDAO;
import br.com.suutz.DAO.UsuarioDAO;
import br.com.suutz.common.GlobalData;
import br.com.suutz.entity.Stock;
import org.h2.engine.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/buyStock")
public class BuyStocksServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("Received request in BuyStocksServlet");

        if(GlobalData.userLogged != null){
            ArrayList<Stock> listStockUser = new ArrayList<>();
            String stockName = req.getParameter("buyStock").toUpperCase();

            double newOrder = StocksDAO.newStockOrder(GlobalData.userLogged.getUser(),stockName);

            req.getSession().setAttribute("saldo" , newOrder);

            resp.sendRedirect("/getStocks");
        }




    }

}
