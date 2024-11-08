package com.example.sd19302.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamDto {

    private Integer id;

    private String maSanPham;

    private String tenSanPham;

    private String tenDanhMuc;

    private String trangThai;
}
