package com.java180115.jee.regForm.service.db.DAO.hibernate;


import com.java180115.jee.regForm.entities.User;
import com.java180115.jee.regForm.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateUserDAO implements UserDAO {
    private HibernateUtils hibernateUtils;

    public HibernateUserDAO(HibernateUtils hibernateUtils) {
        this.hibernateUtils = hibernateUtils;
    }

    @Override
    public boolean save(User user) {
        return saveOrDelete(user, false);
    }

    @Override
    public boolean delete(User user) {
        return saveOrDelete(user, true);
    }

    @Override
    public List<User> findByName(String name) {
        Session session = hibernateUtils.getSession();
        Query query = session.createQuery("from User as n where n.username=?");
        query.setString(0, name);

        return query.list();
    }

    @Override
    public User findById(long id) {
        Session session = hibernateUtils.getSession();

        return (User) session.get(User.class, id);
    }

    private boolean saveOrDelete(User user, boolean delete) {
        Session session = hibernateUtils.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            if (delete) {
                session.delete(user);
            }
            else{
                session.saveOrUpdate(user);
            }
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
