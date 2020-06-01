package ru.kushnarev.controllers;

import ru.kushnarev.entities.Product;
import ru.kushnarev.models.Dao;
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
        String idStr = req.getParameter("id");
        int id;
        try{
            id = Integer.parseInt(idStr);
            Product product = DaoModel.getInstance().getProduct(id);
            req.setAttribute("product", product);
            req.getRequestDispatcher("product.jsp").forward(req,resp);
        }catch (NumberFormatException | NoSuchEntityException nop) {
            //NOP
        }
        resp.sendRedirect("error.jsp");
    }
}
