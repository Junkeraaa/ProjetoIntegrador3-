package br.com.suutz.servlet;

import br.com.suutz.DAO.UsuarioDAO;
import br.com.suutz.common.GlobalData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateBalanceServlet")
public class UpdateBalanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Received request in UpdateBalanceServlet");



       
        System.out.println("USUARIO:  "+ GlobalData.userLogged.getUser());

        if (GlobalData.userLogged != null) {
            
            double newBalance = Double.parseDouble(req.getParameter("newBalance"));


            UsuarioDAO.selectUserBalance(GlobalData.userLogged.getUser());
            UsuarioDAO.updateBalance(GlobalData.userLogged.getUser(), newBalance);

            
            req.getSession().setAttribute("saldo", newBalance);

            resp.sendRedirect(req.getContextPath() + "/getAssets");

        } else {
            System.out.println("Erro: Usuário não autenticado");
            resp.sendRedirect(req.getContextPath() + "/LoggedInPages/MyAssets/myAssets.jsp");
        }
    }
}
