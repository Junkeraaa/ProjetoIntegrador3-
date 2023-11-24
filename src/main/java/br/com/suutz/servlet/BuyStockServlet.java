package br.com.suutz.servlet;

import br.com.suutz.DAO.StocksDAO;
import br.com.suutz.common.GlobalData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/buyStock")
public class BuyStockServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




        req.getRequestDispatcher("LoggedInPages/MyAssets/myAssets.jsp").forward(req, resp);


    }
}
