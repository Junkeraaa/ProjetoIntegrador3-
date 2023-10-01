package br.com.suutz.servlet;

import br.com.suutz.dao.ListUsers;
import br.com.suutz.dao.RegisterDAO;
import br.com.suutz.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-users")
public class ListUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       List<User> allUsers = new ListUsers().findAllUsers();

        req.setAttribute("username", allUsers);

        req.getRequestDispatcher("dashboard.jsp").forward(req,resp);


    }
}
