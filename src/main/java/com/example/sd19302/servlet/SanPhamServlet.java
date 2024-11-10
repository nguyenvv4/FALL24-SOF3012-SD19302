package com.example.sd19302.servlet;

import com.example.sd19302.dto.SanPhamDto;
import com.example.sd19302.model.SanPham;
import com.example.sd19302.repository.SanPhamRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = {"/SanPhamServlet",
        "/san-pham/hien-thi",

})
public class SanPhamServlet extends HttpServlet {

    SanPhamRepo sanPhamRepo = new SanPhamRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/san-pham/hien-thi")) {
            List<SanPham> list = sanPhamRepo.getList();
            request.setAttribute("list", list);
            List<SanPhamDto> listDto = sanPhamRepo.getListDto();
            request.setAttribute("listDto", listDto);
            request.getRequestDispatcher("/san-pham.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
