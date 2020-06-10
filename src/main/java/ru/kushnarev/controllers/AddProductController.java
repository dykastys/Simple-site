package ru.kushnarev.controllers;

import ru.kushnarev.entities.Product;
import ru.kushnarev.entities.User;
import ru.kushnarev.models.impl.DaoModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if(user == null) {
            req.getRequestDispatcher("/authorization").forward(req, resp);
        }
        req.getRequestDispatcher("add_the_product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Double price;
        Product product;

        if(name == null || name.isEmpty()) {
            req.setAttribute("error", "name isn't correct");
            req.getRequestDispatcher("add_the_product.jsp").forward(req, resp);
            return;
        }

        if((price = priceIsNotCorrect(req,resp)) == null) {
            return;
        }

        User user = (User) req.getSession().getAttribute("user");
        product = new Product(user, name, price);
        user.addProductInAddedProduct(product);
        DaoModel.getInstance().putProduct(product);
        req.setAttribute("add", product);
        req.getRequestDispatcher("success.jsp").forward(req,resp);
    }

    private Double priceIsNotCorrect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String price = req.getParameter("price")
                .replaceAll(",",".")
                .replaceAll(" ","");
        try {
            return Double.parseDouble(price);
        }catch (NumberFormatException nop) {
            req.setAttribute("error", "price isn't correct");
            req.getRequestDispatcher("add_the_product.jsp").forward(req,resp);
            return null;
        }
    }
}
