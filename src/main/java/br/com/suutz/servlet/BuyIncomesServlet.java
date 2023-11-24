package br.com.suutz.servlet;

import br.com.suutz.DAO.FixedIncomeDAO;
import br.com.suutz.common.GlobalData;
import br.com.suutz.entity.FixedIncome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
@WebServlet("/buyIncomes")
public class BuyIncomesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Received request in BuyIncomesServlet");

        if(GlobalData.userLogged !=null){

            String incomeName = req.getParameter("buyIncomes");

            try {
                double newOrder = FixedIncomeDAO.newOrder(GlobalData.userLogged.getUser(), incomeName);

                req.getSession().setAttribute("saldo" , newOrder);

                resp.sendRedirect("/getIncomes");



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }



    }
}
