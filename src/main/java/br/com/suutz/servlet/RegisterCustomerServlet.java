package br.com.suutz.servlet;

import br.com.suutz.dao.RegisterDAO;
import br.com.suutz.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username+" "+password);

        User user = new User(username, password);

        int resultRegister = new RegisterDAO().registerUserDAO(user);

        if(resultRegister == 0){
            //Login feito com sucesso
            req.getRequestDispatcher("index.html").forward(req, resp);
        }else if(resultRegister==1){
            req.setAttribute("hasMessage", true);
            req.setAttribute("existUser", "Usuário já existente");

            System.out.println("hasMessage: " + req.getAttribute("hasMessage"));
            System.out.println("message: " + req.getAttribute("existUser"));

            req.getRequestDispatcher("NaoLogada/PaginaRegister/register.jsp").forward(req, resp);
        }else if(resultRegister==2){
            req.setAttribute("hasMessage", true);
            req.setAttribute("passwordMessage", "A senha tem que ter pelo menos 6 caracteres");

            System.out.println("hasMessage: " + req.getAttribute("hasMessage"));
            System.out.println("message: " + req.getAttribute("passwordMessage"));

            req.getRequestDispatcher("NaoLogada/PaginaRegister/register.jsp").forward(req, resp);
        }

}
    }
