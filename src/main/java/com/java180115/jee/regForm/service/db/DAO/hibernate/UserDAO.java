package com.java180115.jee.regForm.service.db.DAO.hibernate;

import com.java180115.jee.regForm.entities.User;

import java.util.List;


public interface UserDAO {
    boolean save(User user);
    boolean delete(User user);
    List<User> findByName(String name);
    User findById(long id);
}
