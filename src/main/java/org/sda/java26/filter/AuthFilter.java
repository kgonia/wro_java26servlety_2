package org.sda.java26.filter;

import org.sda.java26.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebFilter(urlPatterns = "*")
public class AuthFilter implements Filter {

    private List<String> whiteList = List.of("/", "/createUser.jsp", "/login", "/user");

    private Map<String, List<String>> whiteListMap = new HashMap();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        whiteListMap.put("/", List.of("GET"));
        whiteListMap.put("/login", List.of("POST"));
        whiteListMap.put("/user", List.of("POST"));
        whiteListMap.put("/createUser.jsp", List.of("GET"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession httpSession = httpServletRequest.getSession();
        User user = (User) httpSession.getAttribute("loggedInUser");

        String address = httpServletRequest.getRequestURI();
        String method = httpServletRequest.getMethod();

        List<String> methods = whiteListMap.get(address);

        if (methods != null && methods.contains(method)) {
//        if (whiteList.contains(address)) {
            chain.doFilter(request, response); // przechodzimy dalej
        } else if (user != null) { // jeśli jesteśmy zalogowani
            chain.doFilter(request, response); // przechodzimy dalej
        } else {
            RequestDispatcher requestDispatcher
                    = httpServletRequest.getRequestDispatcher("/");
            requestDispatcher.forward(httpServletRequest, httpServletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
