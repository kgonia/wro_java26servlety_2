package org.sda.java26.servlet;

import org.sda.java26.model.User;
import org.sda.java26.repository.UserRepository;
import org.sda.java26.util.PasswordUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login")
public class AuthServlet extends HttpServlet {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = userRepository.getByLogin(login);
        if(user != null && PasswordUtil.checkPassword(password, user.getPassword())){
            req.getSession().setAttribute("loggedInUser", user);

            RequestDispatcher requestDispatcher
                    = req.getRequestDispatcher("/success.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher
                    = req.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
