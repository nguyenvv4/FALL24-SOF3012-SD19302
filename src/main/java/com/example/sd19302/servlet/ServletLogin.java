package com.example.sd19302.servlet;

import com.example.sd19302.model.Users;
import com.example.sd19302.repository.UserRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletLogin", value = {"/login",
        "/logout"
})
public class ServletLogin extends HttpServlet {

    UserRepo userRepo = new UserRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/login")) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if (uri.contains("/logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        Users user = userRepo.getDetailByEmail(email);
        if (user.getId() == null) {
            request.setAttribute("error", "email khong dung");
        } else if (!pass.equals(user.getPassword())) {
            request.setAttribute("error", "password khong dung");
        } else {
            // mo ra trang chu
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("/ketqua.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
