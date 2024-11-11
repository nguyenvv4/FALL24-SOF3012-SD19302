package com.example.sd19302.repository;

import com.example.sd19302.dto.SanPhamDto;
import com.example.sd19302.model.SanPham;
import com.example.sd19302.ultis.HibernateUtils;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SanPhamRepo {

    // hiển thị id, ten sp, ma sp, trang thai, ten danh mục của sản phâm
    // => join
    public List<SanPham> getList() {
        Session session = HibernateUtils.getFACTORY().openSession();
        Query query = session.createQuery("SELECT sp From SanPham sp");
        List<SanPham> list = query.getResultList();
        session.close();
        return list;
    }

    // dung dto
    public List<SanPhamDto> getListDto() {
        Session session = HibernateUtils.getFACTORY().openSession();
        Query query = session.createQuery("SELECT " +
                " new com.example.sd19302.dto.SanPhamDto(sp.id, sp.maSanPham, sp.tenSanPham," +
                " d.tenDanhMuc, sp.trangThai, sp.ngayTao) " +
                " From SanPham sp inner join DanhMuc d " +
                " on sp.danhMuc.id = d.id");
        List<SanPhamDto> list = query.getResultList();
        session.close();
        return list;
    }

    public void addNew(SanPham sanPham) {
        Session session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(sanPham);
        transaction.commit();
        session.close();
    }

}
