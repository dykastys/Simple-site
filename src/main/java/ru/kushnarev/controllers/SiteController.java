package ru.kushnarev.controllers;

import ru.kushnarev.entities.Product;
import ru.kushnarev.entities.User;
import ru.kushnarev.models.exceptions.NoSuchEntityException;
import ru.kushnarev.models.impl.DaoModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SiteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        if(userName != null) {
            goToAccount(req, resp, userName);
            return;
        }
        String idStr = req.getParameter("id");
        goToProduct(req, resp, idStr);
    }

    private void goToAccount(HttpServletRequest req, HttpServletResponse resp, String userName) throws IOException, ServletException {
        User myAccount = (User) req.getSession().getAttribute("user");
        User user;
        try {
            user = DaoModel.getInstance().getUser(userName);
        } catch (NoSuchEntityException ignore) {
            resp.sendRedirect("error.jsp");
            return;
        }
        if(myAccount==null || !myAccount.equals(user)) {
            req.setAttribute("another", user);
            req.getRequestDispatcher("account.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("user", user);
        req.getRequestDispatcher("account.jsp").forward(req, resp);
    }

    private void goToProduct(HttpServletRequest req, HttpServletResponse resp, String idStr) throws ServletException, IOException {
        int id;
        try{
            id = Integer.parseInt(idStr);
            Product product = DaoModel.getInstance().getProduct(id);
            req.setAttribute("product", product);
            req.getRequestDispatcher("product.jsp").forward(req,resp);
        }catch (NumberFormatException | NoSuchEntityException ignore) {
            resp.sendRedirect("error.jsp");
        }
    }
}
