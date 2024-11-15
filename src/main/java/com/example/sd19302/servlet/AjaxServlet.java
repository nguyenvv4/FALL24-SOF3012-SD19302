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
        User1 user = new User1(1, "123456", "Nguyen Van A", "A@gmail.com", true);
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(user);

        // Đặt kiểu dữ liệu trả về là JSON
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        // Gửi dữ liệu JSON về client
        out.print(jsonResponse);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
