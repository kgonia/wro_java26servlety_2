package org.sda.java26.servlet;

import org.sda.java26.repository.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/userlist")
public class UsersServlet extends HttpServlet {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addUsersToRequestAndForward(req, resp);
    }


    private void addUsersToRequestAndForward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // List<User> userList = userRepository.findUsers();
        req.setAttribute("users", userRepository.findUsers());

        RequestDispatcher requestDispatcher
                = req.getRequestDispatcher("/usersList.jsp");
        requestDispatcher.forward(req, resp);
    }
}
