package org.sda.java26.servlet;

import org.sda.java26.model.User;
import org.sda.java26.repository.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/user")
public class CreateUserServlet extends HttpServlet {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addUsersToRequestAndForward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = getUserParamsAndCreateUser(req);
        if (user == null) {
            RequestDispatcher requestDispatcher
                    = req.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(req, resp);
        }
        userRepository.saveUser(user);

        addUsersToRequestAndForward(req, resp);
    }

    private User getUserParamsAndCreateUser(HttpServletRequest req) {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        if (name == null || surname == null || login == null || password == null || email == null) {
            return null;
        }

        User user = new User(name, surname, login, password, email);
        return user;
    }

    private void addUsersToRequestAndForward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // List<User> userList = userRepository.findUsers();
        req.setAttribute("users", userRepository.findUsers());

        RequestDispatcher requestDispatcher
                = req.getRequestDispatcher("/usersList.jsp");
        requestDispatcher.forward(req, resp);
    }
}
