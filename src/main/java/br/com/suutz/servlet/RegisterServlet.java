package br.com.suutz.servlet;

import br.com.suutz.DAO.RegisterDAO;
import br.com.suutz.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username+" "+password);

        User user = new User();
        user.setUser(username);
        user.setPassword(password);

        new RegisterDAO();
		int resultRegister = RegisterDAO.registerUserDAO(user);

        if(resultRegister == 0){

            System.out.println("Register Success");

            req.setAttribute("hasMessageFinal" , true);
            req.setAttribute("Success", "Cadastrado com sucesso!");
            req.getRequestDispatcher("LoggedOutPages/RegisterPage/register.jsp").forward(req, resp);

            //Will show a message that the register was a success and after 3 sec, will redirect to index.html

            String redirectScript = "<script>setTimeout(function() { window.location.href = 'index.html'; }, 3000);</script>";
            resp.getWriter().println(redirectScript);




        }else if(resultRegister==1){

            req.setAttribute("hasMessageUser", true);
            req.setAttribute("existUser", "Usuário já existente");

            req.getRequestDispatcher("LoggedOutPages/RegisterPage/register.jsp").forward(req, resp);

        }else if(resultRegister==2){

            req.setAttribute("hasMessagePassword", true);
            req.setAttribute("passwordMessage", "A senha tem que ter pelo menos 6 caracteres");

            req.getRequestDispatcher("LoggedOutPages/RegisterPage/register.jsp").forward(req, resp);
        }

}
    }
