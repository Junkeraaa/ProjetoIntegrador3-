package br.com.suutz.servlet;

import br.com.suutz.DAO.LoginDAO;
import br.com.suutz.DAO.UsuarioDAO;
import br.com.suutz.common.GlobalData;
import br.com.suutz.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    User user;
    String username;
    String password;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         username = req.getParameter("username");
         password = req.getParameter("password");

        LoginDAO loginDAO = new LoginDAO();
        user = loginDAO.loginUser(username, password);

        if (user != null) {

            System.out.println("Login Success");

            req.getSession().setAttribute("user", user.getUser());

            resp.sendRedirect(req.getContextPath() + "/LoggedInPages/loggedIn.jsp");

        } else {

            System.out.println("Login Falied");
            req.setAttribute("hasMessage", true);
            req.setAttribute("message", "Usuário ou senha incorretos");

            req.getRequestDispatcher("/LoggedOutPages/Login/login.jsp").forward(req, resp);

        }

    }

}


