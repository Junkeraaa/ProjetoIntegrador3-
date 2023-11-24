package br.com.suutz.servlet;

import br.com.suutz.DAO.FixedIncomeDAO;
import br.com.suutz.entity.FixedIncome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet("/getIncomes")
public class IncomesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            ArrayList<FixedIncome> incomesList = FixedIncomeDAO.getIncomes();
        
            req.setAttribute("incomesList", incomesList);

            req.getRequestDispatcher("/LoggedInPages/Incomes/incomes.jsp").forward(req, resp);
    }
}
