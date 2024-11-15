package com.example.sd19302.servlet;

import com.example.sd19302.model.User1;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxServlet", value = "/api/test-ajax")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/demoAjax.jsp").forward(request, response);
        User1 user = new User1(1, "123456", "Nguyen Van A", "A@gmail.com", true);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        Gson gson = new Gson();
        String json = gson.toJson(user);
//        response.getWriter().print(json);
        PrintWriter out = response.getWriter();
        // Gửi dữ liệu JSON về client
        out.print(json);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
