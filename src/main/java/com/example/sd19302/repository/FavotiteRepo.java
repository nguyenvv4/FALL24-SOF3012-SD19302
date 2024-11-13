package com.example.sd19302.repository;

import com.example.sd19302.dto.FavoriteDto;
import com.example.sd19302.dto.SanPhamDto;
import com.example.sd19302.ultis.HibernateUtils;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class FavotiteRepo {
    public List<FavoriteDto> getList() {
        Session session = HibernateUtils.getFACTORY().openSession();
        String sql = "select new com.example.sd19302.dto.FavoriteDto (" +
                " u.fullname, u.email, v.poster, v.description, v.view, f.likeDate) " +
                " from User1 u inner join Favorite f " +
                " on u.id = f.user.id " +
                " inner join Video v " +
                " on v.id = f.video.id ";
        Query query = session.createQuery(sql);
        List<FavoriteDto> list = query.getResultList();
        session.close();
        return list;
    }
}
