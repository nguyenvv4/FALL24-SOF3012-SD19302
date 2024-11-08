package com.example.sd19302.repository;

import com.example.sd19302.dto.SanPhamDto;
import com.example.sd19302.ultis.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SanPhamRepo {

    DbConnection dbConnection;

    public ArrayList<SanPhamDto> getList() {
        String sql = "SELECT dbo.san_pham.id, dbo.san_pham.ma_san_pham, dbo.san_pham.ten_san_pham, dbo.danh_muc.ten_danh_muc, dbo.san_pham.trang_thai\n" +
                " FROM dbo.danh_muc INNER JOIN\n" +
                " dbo.san_pham ON dbo.danh_muc.id = dbo.san_pham.id_danh_muc";
        ArrayList<SanPhamDto> list = new ArrayList<>();
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String maSanPham  = rs.getString(2);
                String tenSanPham  = rs.getString(3);
                String tenDanhMuc  = rs.getString(4);
                String trangThai  = rs.getString(5);
                list.add(new SanPhamDto(id,maSanPham,tenSanPham,tenDanhMuc, trangThai));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
