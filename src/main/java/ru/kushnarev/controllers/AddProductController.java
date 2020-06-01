package ru.kushnarev.controllers;

import ru.kushnarev.entities.Product;
import ru.kushnarev.models.impl.DaoModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("add_the_product.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        double price;
        try {
            price = Double.parseDouble(req.getParameter("price"));
            Product product = new Product(name, price);
            DaoModel.getInstance().db.put(String.format("http://localhost:8080/eshop/product?id=%s",product.getId()), product);
            req.getRequestDispatcher("successfully_adding_the_product.jsp").forward(req,resp);
        }catch (NumberFormatException nop) {
            req.getRequestDispatcher("error_when_adding_ the_product.jsp").forward(req,resp);
        }
    }
}
