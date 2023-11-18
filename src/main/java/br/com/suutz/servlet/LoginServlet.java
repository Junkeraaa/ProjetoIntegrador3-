package br.com.suutz.servlet;

import br.com.suutz.DAO.FixedIncomeDAO;
import br.com.suutz.DAO.LoginDAO;
import br.com.suutz.DAO.StocksDAO;
import br.com.suutz.DAO.UsuarioDAO;
import br.com.suutz.common.updateStocksPrice;
import br.com.suutz.common.utils;
import br.com.suutz.entity.FixedIncome;
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
    int i = 0;
    ArrayList<Stock> stocksList = new ArrayList();
    ArrayList<Double> stockInitialValues = new ArrayList();
    ArrayList<Double> stockBalance = new ArrayList();

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
            //fim login




            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);

            scheduler.scheduleAtFixedRate(() -> {
                initializeStockInitialValues(req);
                updateStocksPrice.updateStocksPriceFunction();
//              HttpServletRequest request = (HttpServletRequest) req.getSession().getAttribute("request");
                req.getSession().setAttribute("stocksList", stocksList);
            }, 0, 2, TimeUnit.SECONDS);
        } else {
            System.out.println("Login Failed");
            req.setAttribute("hasMessage", true);
            req.setAttribute("message", "Usuário ou senha incorretos");

            req.getRequestDispatcher("/LoggedOutPages/Login/login.jsp").forward(req, resp);
        }
    }

    public void setIncomesData(HttpServletRequest req){

        ArrayList<FixedIncome> incomesList = FixedIncomeDAO.getIncomes();

        req.getSession().setAttribute("incomesList", incomesList);
        for(FixedIncome a : incomesList){
            System.out.println(a.getName() + "///");
        }
    }
    public void initializeStockInitialValues(HttpServletRequest req) {

        System.out.println("Inicializou ISIV");
        ArrayList<Stock> stocksList = StocksDAO.getStocks();

        stockInitialValues.add(83.2);
        stockInitialValues.add(1.2);
        stockInitialValues.add(27.92);
        stockInitialValues.add(16.33);
        stockInitialValues.add(51.25);
        stockInitialValues.add(0.11);
        stockInitialValues.add(14.16);
        stockInitialValues.add(2.27);
        stockInitialValues.add(95.8);
        stockInitialValues.add(22.22);
        req.getSession().setAttribute("stockInitialValues", stockInitialValues);

        for(int i = 0; i < stocksList.size(); i++ ){


          double res = stockInitialValues.get(i) - stocksList.get(i).getPriceStock();


           double res2 = Math.floor(res * 1000)/100;

            stockBalance.add(res2);

        }

        req.getSession().setAttribute("stockBalance", stockBalance);

    }


}
