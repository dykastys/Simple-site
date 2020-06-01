package ru.kushnarev.controllers;

import ru.kushnarev.models.impl.PasswordContainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VerificationController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if(login==null || password==null || login.isEmpty() || password.isEmpty()
                || !PasswordContainer.getLogins().containsKey(login)
                || !password.equals(PasswordContainer.getLogins().get(login))) {
            req.getRequestDispatcher("error_authorization.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("/add_product").forward(req,resp);
    }
}
