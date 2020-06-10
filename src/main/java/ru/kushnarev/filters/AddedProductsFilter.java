package ru.kushnarev.filters;

import ru.kushnarev.entities.Product;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class AddedProductsFilter extends BaseFilter {

    @Override
    void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Map<Product,String> addedProd = (Map<Product, String>) request.getAttribute("addedProd");

    }
}
