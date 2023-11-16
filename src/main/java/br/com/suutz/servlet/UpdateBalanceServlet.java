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



        // Obtenha o usuário da sessão
        System.out.println("USUARIO:  "+ GlobalData.userLogged.getUser());

        String a = GlobalData.userLogged.getUser();


        if (GlobalData.userLogged != null) {
            // Obtenha os parâmetros do formulário
            double newBalance = Double.parseDouble(req.getParameter("newBalance"));

            // Crie uma instância de UsuarioDAO e chame o método de atualização de saldo
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.selectUserBalance(GlobalData.userLogged.getUser());//Alterar método para que já dê um set e atualize no front
            usuarioDAO.updateBalance(GlobalData.userLogged.getUser(), newBalance);

            // Atualize o saldo na sessão
            req.getSession().setAttribute("saldo", newBalance);

            resp.sendRedirect(req.getContextPath() + "/LoggedInPages/MyAssets/myAssets.jsp");

        } else {
            System.out.println("Erro: Usuário não autenticado");
            resp.sendRedirect(req.getContextPath() + "/LoggedInPages/MyAssets/myAssets.jsp");
        }
    }
}
