package ru.kushnarev.controllers;

import ru.kushnarev.entities.User;
import ru.kushnarev.models.exceptions.NoSuchEntityException;
import ru.kushnarev.models.impl.DaoModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user;

        checkOnNull(req, resp, login, password);

        if ((user = checkDataInDB(req, resp, login, password)) == null) {
            return;
        }

        req.getSession().setAttribute("user", user);
        resp.sendRedirect(req.getContextPath() + "/");
    }

    private void checkOnNull(HttpServletRequest request, HttpServletResponse response, String login, String password) throws ServletException, IOException {
        if(login==null || password==null || login.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "login or password is empty");
            request.getRequestDispatcher("authorization.jsp").forward(request, response);
        }
    }

    private User checkDataInDB(HttpServletRequest request, HttpServletResponse response, String login, String password) throws ServletException, IOException {
        password = String.valueOf(password.hashCode());
        try {
            User user = DaoModel.getInstance().getUser(login);
            if(!user.getPassword().equals(password)) {
                throw new NoSuchEntityException("passwords aren't equals");
            }
            return user;
        } catch (NoSuchEntityException e) {
            request.setAttribute("error", "this account is not found");
            request.getRequestDispatcher("authorization.jsp").forward(request, response);
            return null;
        }
    }
}
