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

public class EditProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("id");
        int id;
        try{
            id = Integer.parseInt(productId);
            Product product = DaoModel.getInstance().getProduct(id);
            req.setAttribute("product", product);
            req.getRequestDispatcher("edit_product.jsp").forward(req, resp);
        }catch (NumberFormatException | NoSuchEntityException ignore) {
            resp.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().endsWith("delete_product")) {
            doDelete(req, resp);
        }
        String strId = req.getParameter("id");
        Product product = getProduct(req, resp, strId);
        String productName = req.getParameter("name");
        String productPrice = req.getParameter("price");

        setName(req, product, productName);
        setPrice(req, product, productPrice);

        req.setAttribute("product", product);
        req.getRequestDispatcher("edit_product.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String delParam = req.getParameter("del");
        String strId = req.getParameter("id");
        if(delParam == null) {
            applyOrCancelDelete(req, resp, strId);
        }else{
            Product product = getProduct(req, resp, strId);
            confirmDelete(req, resp, product, delParam);
        }
    }

    private Product getProduct(HttpServletRequest req, HttpServletResponse resp, String strId) throws ServletException, IOException {
        Product product = null;
        try {
            product = DaoModel.getInstance().getProduct(Integer.parseInt(strId));
        } catch (NoSuchEntityException e) {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
        return product;
    }

    private void setName(HttpServletRequest req, Product product, String productName) {
        if(productName == null || productName.isEmpty()) {
            req.setAttribute("error_name", "product name is empty");
        }else{
            product.setName(productName);
            req.setAttribute("name_success", "the name is successfully changed");
        }
    }

    private void setPrice(HttpServletRequest req, Product product, String productPrice) {
        if(productPrice == null || productPrice.isEmpty()) {
            req.setAttribute("error_price", "product price is empty");
        }else{
            try {
                product.setPrice(Double.parseDouble(productPrice));
                req.setAttribute("price_success", "the price is successfully changed");
            } catch (NumberFormatException e) {
                req.setAttribute("error_price", "product price isn't correct");
            }
        }
    }

    private void applyOrCancelDelete(HttpServletRequest req, HttpServletResponse resp, String strId) throws ServletException, IOException {
        try{
            Product product = DaoModel.getInstance().getProduct(Integer.parseInt(strId));
            req.setAttribute("delete", product);
            req.getRequestDispatcher("edit_product.jsp").forward(req, resp);
        }catch (NumberFormatException | NoSuchEntityException | ServletException | IOException e) {
            req.setAttribute("error", "product is not found");
            req.getRequestDispatcher("edit_product.jsp").forward(req, resp);
        }
    }

    private void confirmDelete(HttpServletRequest req, HttpServletResponse resp, Product product, String delParam) throws ServletException, IOException {
        switch (delParam) {
            case "ok":
                DaoModel.getInstance().getProductDB().remove(product);
                req.setAttribute("delete", product);
                User user = (User) req.getSession().getAttribute("user");
                user.getAddedProducts().remove(product);
                req.getRequestDispatcher("success.jsp").forward(req, resp);
                break;
            case "cancel":
                req.setAttribute("product", product);
                req.getRequestDispatcher("edit_product.jsp").forward(req, resp);
                break;
        }
    }
}
