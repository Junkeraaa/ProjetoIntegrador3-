package br.com.suutz.servlet;

import br.com.suutz.dao.LoginDAO;
import br.com.suutz.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        LoginDAO loginDAO = new LoginDAO();
        User user = loginDAO.loginUser(username, password);

        if (user != null) {

            System.out.println("Logado");
            resp.sendRedirect("logado.html");
        } else {

            System.out.println("N logado");
            resp.sendRedirect("naologado.html");
        }
    }
}

