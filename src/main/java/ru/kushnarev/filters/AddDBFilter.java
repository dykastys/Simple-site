package ru.kushnarev.filters;

import ru.kushnarev.entities.Product;
import ru.kushnarev.models.impl.DaoModel;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class AddDBFilter extends BaseFilter {

    @Override
    void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Set<Product> db = (Set<Product>) request.getAttribute("db");
        if(db == null || !db.equals(DaoModel.getInstance().getProductDB())) {
            request.setAttribute("db", DaoModel.getInstance().getProductDB());
        }
        chain.doFilter(request, response);
    }
}
