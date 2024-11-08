package com.example.sd19302.servlet;

import com.example.sd19302.dto.SanPhamDto;
import com.example.sd19302.model.Users;
import com.example.sd19302.repository.SanPhamRepo;
import com.example.sd19302.repository.UserRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet", value = {"/home",
        "/user",
        "/add",
        "/detail",
        "/delete"
})
public class HomeServlet extends HttpServlet {

    SanPhamRepo sanPhamRepo = new SanPhamRepo();
    UserRepo userRepo = new UserRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/home")) {
            ArrayList<SanPhamDto> list = sanPhamRepo.getList();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } else if (uri.contains("/user")) {
            List<Users> list = userRepo.getList();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/user.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            Users user = userRepo.getDetailById(request.getParameter("id"));
            request.setAttribute("user", user);
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            Users user = userRepo.getDetailById(request.getParameter("id"));
            if (user != null) {
                userRepo.delete(user);
            }
            response.sendRedirect("/user");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String id = request.getParameter("id");
            String fullname = request.getParameter("fullname");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            Boolean admin = Boolean.valueOf(request.getParameter("admin"));
            Users user = new Users(id, password, fullname, email, admin);
            userRepo.add(user);
            response.sendRedirect("/user");
        }
    }
}
