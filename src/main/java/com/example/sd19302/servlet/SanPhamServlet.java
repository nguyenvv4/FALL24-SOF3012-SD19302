package com.example.sd19302.servlet;

import com.example.sd19302.dto.SanPhamDto;
import com.example.sd19302.model.DanhMuc;
import com.example.sd19302.model.SanPham;
import com.example.sd19302.repository.DanhMucRepo;
import com.example.sd19302.repository.SanPhamRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = {"/SanPhamServlet",
        "/san-pham/hien-thi",
        "/san-pham/add",
        "/san-pham/detail",
        "/san-pham/delete",
        "/san-pham/update",

})
public class SanPhamServlet extends HttpServlet {

    SanPhamRepo sanPhamRepo = new SanPhamRepo();
    DanhMucRepo danhMucRepo = new DanhMucRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/san-pham/hien-thi")) {
            List<SanPham> list = sanPhamRepo.getList();
            request.setAttribute("list", list);
//            List<SanPhamDto> listDto = sanPhamRepo.getListDto();
//            request.setAttribute("listDto", listDto);
            request.setAttribute("listDanhMuc", danhMucRepo.getList());
            request.getRequestDispatcher("/san-pham.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            SanPham sanPham = sanPhamRepo.getDetail(id);
            sanPhamRepo.delete(sanPham);
            response.sendRedirect("/san-pham/hien-thi");
        } else if (uri.contains("/detail")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            SanPham sanPham = sanPhamRepo.getDetail(id);
            request.setAttribute("sanPham", sanPham);
            request.setAttribute("listDanhMuc", danhMucRepo.getList());
            request.getRequestDispatcher("/san-pham-detail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/san-pham/add")) {
            String maSanPham = request.getParameter("maSanPham");
            String tenSanPham = request.getParameter("tenSanPham");
            String trangThai = request.getParameter("trangThai");
            Integer danhMuc = Integer.parseInt(request.getParameter("danhMuc"));
            SanPham sanPham = new SanPham();
            sanPham.setMaSanPham(maSanPham);
            sanPham.setTenSanPham(tenSanPham);
            sanPham.setTrangThai(trangThai);
            sanPham.setNgayTao(new Date());
            DanhMuc dm = new DanhMuc();
            dm.setId(danhMuc);
            sanPham.setDanhMuc(dm);
            sanPhamRepo.addNew(sanPham);
            response.sendRedirect("/san-pham/hien-thi");
        } else if (uri.contains("/update")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String maSanPham = request.getParameter("maSanPham");
            String tenSanPham = request.getParameter("tenSanPham");
            String trangThai = request.getParameter("trangThai");
            Integer danhMuc = Integer.parseInt(request.getParameter("danhMuc"));
            SanPham sanPham = new SanPham();
            sanPham.setId(id);
            sanPham.setMaSanPham(maSanPham);
            sanPham.setTenSanPham(tenSanPham);
            sanPham.setTrangThai(trangThai);
            sanPham.setNgayTao(new Date());
            DanhMuc dm = new DanhMuc();
            dm.setId(danhMuc);
            sanPham.setDanhMuc(dm);
            sanPhamRepo.addNew(sanPham);
            response.sendRedirect("/san-pham/hien-thi");

        }
    }
}
