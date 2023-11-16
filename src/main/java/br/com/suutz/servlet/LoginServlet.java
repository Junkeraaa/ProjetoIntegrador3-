package br.com.suutz.servlet;

import br.com.suutz.DAO.LoginDAO;
import br.com.suutz.DAO.UsuarioDAO;
import br.com.suutz.common.updateStocksPrice;
import br.com.suutz.common.utils;
import br.com.suutz.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    User user;
    String username;
    String password;
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

            utils.sendPageLoginDao(req, resp);

            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(updateStocksPrice::updateStocksPriceFunction, 0, 15, TimeUnit.SECONDS);


        } else {

            System.out.println("Login Falied");
            req.setAttribute("hasMessage", true);
            req.setAttribute("message", "Usuário ou senha incorretos");

            req.getRequestDispatcher("/LoggedOutPages/Login/login.jsp").forward(req, resp);

        }

    }

}


