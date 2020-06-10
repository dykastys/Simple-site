package ru.kushnarev.filters;

import ru.kushnarev.entities.User;
import ru.kushnarev.models.exceptions.NoSuchEntityException;
import ru.kushnarev.models.impl.DaoModel;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Checked in session user authorization
 */
public class AuthorizationForJSPFilter extends BaseFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(verificationAccount(user)) {
            chain.doFilter(request,response);
            return;
        }
        session.setAttribute("user",null);
        chain.doFilter(request,response);
    }

    private boolean verificationAccount(User user) {
        if(user == null) {
            return false;
        }
        try {
            DaoModel.getInstance().getUser(user.getName());
            return true;
        } catch (NoSuchEntityException e) {
            return false;
        }
    }
}
