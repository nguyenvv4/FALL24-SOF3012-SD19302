package com.example.sd19302.repository;

import com.example.sd19302.model.Users;
import com.example.sd19302.ultis.HibernateUtils;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserRepo {

    public List<Users> getList() {
        Session session = HibernateUtils.getFACTORY().openSession();
        Query query = session.createQuery("SELECT u From Users u");
        List<Users> list = query.getResultList();
        session.close();
        return list;
    }

    public void add(Users user){
        Session session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public Users getDetailById(String id) {
        Session session = HibernateUtils.getFACTORY().openSession();
        Query query = session.createQuery("SELECT u From Users u where u.id = :idUser");
        query.setParameter("idUser", id);
        Users user = (Users) query.getSingleResult();
        session.close();
        return user;
    }

    public void delete(Users user){
        Session session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

}
