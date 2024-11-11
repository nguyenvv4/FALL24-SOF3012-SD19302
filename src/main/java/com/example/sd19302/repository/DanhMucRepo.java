package com.example.sd19302.repository;

import com.example.sd19302.model.SanPham;
import com.example.sd19302.ultis.HibernateUtils;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class DanhMucRepo {

    public List<SanPham> getList() {
        Session session = HibernateUtils.getFACTORY().openSession();
        Query query = session.createQuery("SELECT sp From DanhMuc sp");
        List<SanPham> list = query.getResultList();
        session.close();
        return list;
    }
}
