package ru.kushnarev.controllers;

import ru.kushnarev.entities.User;
import ru.kushnarev.models.exceptions.NoValidDataException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditAccountController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("edit_account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String login = req.getParameter("login");
        String phone = req.getParameter("phone");
        String age = req.getParameter("age");
        String lastPassword = req.getParameter("lastPass");
        String newPassword = req.getParameter("newPass");

        setLogin(req, user, login);
        setPhone(req, user, phone);
        setAge(req, user, age);
        setPassword(req, user, lastPassword, newPassword);

        req.getRequestDispatcher("edit_account.jsp").forward(req, resp);
    }

    private void setLogin(HttpServletRequest req, User user, String login) {
        if(login == null || login.isEmpty()) {
        }else if(!login.equals(user.getName())){
            user.setName(login);
            req.setAttribute("login_success","login has been successfully changed");
        }
    }

    private void setPhone(HttpServletRequest req, User user, String phone) {
        if(phone == null || phone.isEmpty()) {
        }else if(!phone.equals(user.getPhone())) {
            try {
                user.setPhone(phone);
                req.setAttribute("phone_success", "phone has been successfully changed");
            } catch (NoValidDataException e) {
                req.setAttribute("phone_error", "entered phone number isn't valid");
            }
        }
    }

    private void setAge(HttpServletRequest req, User user, String age) {
        if(age == null || age.isEmpty()) {
        }else{
            try{
                user.setAge(Integer.parseInt(age));
                req.setAttribute("age_success", "age has been successfully changed");
            }catch (NumberFormatException | NoValidDataException e) {
                req.setAttribute("age_error","age isn't valid");
            }
        }
    }

    private void setPassword(HttpServletRequest req, User user, String lastPassword, String newPassword) {
        if(lastPassword==null || newPassword==null || lastPassword.isEmpty() || newPassword.isEmpty()) {
        }else if(lastPassword.equals(newPassword)){
            req.setAttribute("password_error", "passwords are equals");
        }else if(!String.valueOf(lastPassword.hashCode()).equals(user.getPassword())){
            req.setAttribute("password_error", "last password d'ont equals which user password");
        }else{
            user.setPassword(String.valueOf(newPassword.hashCode()));
            req.setAttribute("password_success", "password has been successfully changed");
        }
    }
}
