package com.example.sd19302.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SanPhamDto {

    @Id
    private Integer id;

    private String maSanPham;

    private String tenSanPham;

    private String tenDanhMuc;

    private String trangThai;

    private Date ngayTao;
}
