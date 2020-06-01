package ru.kushnarev.filters;

import ru.kushnarev.entities.Product;
import ru.kushnarev.models.impl.DaoModel;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class AddBaseFilter extends BaseFilter {

    @Override
    void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Map<String, Product> db = (Map<String, Product>) request.getAttribute("db");
        if(db == null || !db.equals(DaoModel.getInstance().db)) {
            request.setAttribute("db", DaoModel.getInstance().db);
        }
        chain.doFilter(request, response);
    }
}
