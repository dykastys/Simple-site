package ru.kushnarev.controllers;

import ru.kushnarev.entities.User;
import ru.kushnarev.models.exceptions.NoSuchEntityException;
import ru.kushnarev.models.exceptions.NoValidDataException;
import ru.kushnarev.models.impl.DaoModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateAccountController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("create_the_account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pass1 = req.getParameter("password1");
        String pass2 = req.getParameter("password2");
        String login;
        String phone;

        if (checkPasswordsOnNull(pass1, pass2)) {
            req.setAttribute("error", "passwords are empty or don't match");
            req.getRequestDispatcher("create_the_account.jsp").forward(req,resp);
            return;
        }

        login = req.getParameter("login");
        checkLoginOnNull(req, resp, login);
        checkLoginMatch(req, resp, login);

        phone = req.getParameter("phone");
        try {
            addAccount(req, resp, login, pass1, phone);
        } catch (NoValidDataException e) {
            req.setAttribute("error", "phone isn't valid");
            req.getRequestDispatcher("create_the_account.jsp").forward(req,resp);
        }
    }

    private boolean checkPasswordsOnNull(String pass1, String pass2) {
        return pass1 == null || pass2 == null || pass1.isEmpty() || pass2.isEmpty() || !pass1.equals(pass2);
    }

    private void checkLoginOnNull(HttpServletRequest req, HttpServletResponse resp, String login) throws ServletException, IOException {
        if(login==null || login.isEmpty() ) {
            req.setAttribute("error", "the username is empty");
            req.getRequestDispatcher("create_the_account.jsp").forward(req,resp);
        }
    }

    private void checkLoginMatch(HttpServletRequest req, HttpServletResponse resp, String login) throws ServletException, IOException {
        try {
            DaoModel.getInstance().getUser(login);
            req.setAttribute("error", "the username is already taken");
            req.getRequestDispatcher("create_the_account.jsp").forward(req,resp);
        } catch (NoSuchEntityException ignore) {
        }
    }

    private void addAccount(HttpServletRequest req, HttpServletResponse resp, String login, String pass, String phone) throws NoValidDataException, ServletException, IOException {
        User user = new User(login, String.valueOf(pass.hashCode()));
        user.setPhone(phone);
        DaoModel.getInstance().putUser(user);
        req.getSession().setAttribute("user", user);
        req.setAttribute("creation", user);
        req.getRequestDispatcher("success.jsp").forward(req,resp);
    }
}
