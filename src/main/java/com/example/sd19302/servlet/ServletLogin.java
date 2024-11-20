package com.example.sd19302.servlet;

import com.example.sd19302.model.Users;
import com.example.sd19302.repository.UserRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletLogin", value = "/login")
public class ServletLogin extends HttpServlet {

    UserRepo userRepo = new UserRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
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
