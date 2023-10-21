//package br.com.suutz.servlet;
//
//import br.com.suutz.DAO.LoginDAO;
//import br.com.suutz.entity.User;
//
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//@WebServlet("/profile")
//public class LoggedInServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        LoginDAO loginDAO = new LoginDAO();
//        User user = loginDAO.loginUser(username, password);
//
//        if (user != null) {
//            req.setAttribute("user", user.getUser());
//        }
//    }
//}
//
