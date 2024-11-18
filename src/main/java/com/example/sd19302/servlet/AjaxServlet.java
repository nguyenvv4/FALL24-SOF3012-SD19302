package com.example.sd19302.servlet;

import com.example.sd19302.model.SanPham;
import com.example.sd19302.model.User1;
import com.example.sd19302.repository.SanPhamRepo;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxServlet", value = "/api/test-ajax")
public class AjaxServlet extends HttpServlet {

    SanPhamRepo sanPhamRepo = new SanPhamRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SanPham sanPham = sanPhamRepo.getDetail(Integer.parseInt(request.getParameter("id")));
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(sanPham);

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
