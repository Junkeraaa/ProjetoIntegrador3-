package br.com.suutz.servlet;


import br.com.suutz.common.*;

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

@WebServlet("/getAssets")
public class MyAssetsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<MyAssetsStocksInterface> listStockUser= ReturnStocksByUser.ReturnStocksByUserFunction(GlobalData.userLogged);
        ArrayList<MyAssetsFixedIncomeInterface> listIncomeUser = ReturnFixedIncomesByUser.ReturnFixedIncomesByUserFunction((GlobalData.userLogged));


        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        scheduler.scheduleAtFixedRate(() -> {
            updateStocksPrice.updateStocksPriceFunction();
            req.setAttribute("listStockUser", listStockUser);
            req.setAttribute("listIncomeUser", listIncomeUser);
        }, 0, 2, TimeUnit.SECONDS);

        req.setAttribute("listIncomeUser", listIncomeUser);

        req.setAttribute("listStockUser", listStockUser);

        req.getRequestDispatcher("/LoggedInPages/MyAssets/myAssets.jsp").forward(req, resp);



    }
}
