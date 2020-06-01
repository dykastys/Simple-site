package ru.kushnarev.controllers;

import ru.kushnarev.models.impl.PasswordContainer;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddAccountController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pass1 = req.getParameter("password1");
        String pass2 = req.getParameter("password2");
        String login;

        if(pass1.equals(pass2)) {
            login = req.getParameter("login");
            PasswordContainer.getLogins().put(login, pass1);
            resp.addCookie(new Cookie("login", login));
            resp.addCookie(new Cookie("password", pass1));
            req.getRequestDispatcher("successful_creation.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("error_account_creation.jsp").forward(req,resp);
        }
    }
}
