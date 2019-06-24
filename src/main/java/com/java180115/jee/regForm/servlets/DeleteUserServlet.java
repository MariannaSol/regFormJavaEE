package com.java180115.jee.regForm.servlets;

import com.java180115.jee.regForm.entities.User;
import com.java180115.jee.regForm.service.db.DAO.hibernate.HibernateUserDAO;
import com.java180115.jee.regForm.service.db.DAO.hibernate.UserDAO;
import com.java180115.jee.regForm.utils.HibernateUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {
    private String username;
    private long id;
    private User userToDelete;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        id = Long.parseLong(req.getParameter("idToDelete"));

        try (HibernateUtils hibernateUtils = new HibernateUtils()) {
            UserDAO userDAO = new HibernateUserDAO(hibernateUtils);

            userToDelete = userDAO.findById(id);

            if(userToDelete == null) {
                resp.getWriter().print("User not found");
            } else userDAO.delete(userToDelete);
        }

        resp.getWriter().print("Delete User " + userToDelete.getUsername());
    }
}
