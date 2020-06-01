package ru.kushnarev.filters;

import ru.kushnarev.models.impl.PasswordContainer;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutorisationFilter extends BaseFilter {

    @Override
    void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String login = "";
        String password = "";
        if(request.getCookies() != null) {
            for (Cookie cookie: request.getCookies()) {
                if(cookie.getName().equals("login")) {
                    login = cookie.getValue();
                }
                if(cookie.getName().equals("password")) {
                    password = cookie.getValue();
                }
            }
            if(PasswordContainer.getLogins().containsKey(login)) {
                if(PasswordContainer.getLogins().get(login).equals(password)) {
                    chain.doFilter(request, response);
                    return;
                }
            }
        }
        response.sendRedirect("authorization.jsp");
    }
}
