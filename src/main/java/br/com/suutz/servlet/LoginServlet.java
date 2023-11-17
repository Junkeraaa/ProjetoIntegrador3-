package br.com.suutz.servlet;

import br.com.suutz.DAO.LoginDAO;
import br.com.suutz.DAO.StocksDAO;
import br.com.suutz.DAO.UsuarioDAO;
import br.com.suutz.common.updateStocksPrice;
import br.com.suutz.common.utils;
import br.com.suutz.entity.Stock;
import br.com.suutz.entity.User;

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


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private User user;
    private String username;
    private String password;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        username = req.getParameter("username");
        password = req.getParameter("password");

        user = LoginDAO.loginUser(username, password);

        if (user != null) {
            System.out.println("Login Success");

            double currentBalance = UsuarioDAO.selectUserBalance(username);
            req.getSession().setAttribute("saldo", currentBalance);

            req.getSession().setAttribute("user", user.getUser());


            // Redirect to the loggedIn.jsp page
            utils.sendPageLoginDao(req, resp);

            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

            scheduler.scheduleAtFixedRate(() -> {
                System.out.println("Entrou na bunda");
                updateStocksPrice.updateStocksPriceFunction();
                setStocksData(req);
            }, 0, 2, TimeUnit.SECONDS);
        } else {
            System.out.println("Login Failed");
            req.setAttribute("hasMessage", true);
            req.setAttribute("message", "Usuário ou senha incorretos");

            req.getRequestDispatcher("/LoggedOutPages/Login/login.jsp").forward(req, resp);
        }
    }

    public void setStocksData(HttpServletRequest req){

       
        ArrayList<Stock> stocksList = StocksDAO.getStocks();
       
            // Set stocksList as a request attribute
            req.getSession().setAttribute("stocksList", stocksList);
     
            for(Stock a : stocksList){
                System.out.println("banan");
                System.out.println(a.getPriceStock() + "///");
            }
    }
}
