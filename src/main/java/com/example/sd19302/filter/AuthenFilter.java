package com.example.sd19302.filter;

import com.example.sd19302.model.Users;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/san-pham/*", "/admin/*"})
public class AuthenFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        HttpSession session = req.getSession();
        Users user = (Users) session.getAttribute("user");
        if (user == null){
            req.getRequestDispatcher("/login.jsp").forward(req, res);
        }
        Boolean isAdmin = user.getAdmin();

        if (isAdmin == true) {
            chain.doFilter(request, response);
        } else {
            if (uri.startsWith("/san-pham")) {
                chain.doFilter(request, response);
            } else {
                req.getRequestDispatcher("/khong-co-quyen.jsp").forward(req, res);
            }
        }

    }
}
