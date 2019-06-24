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
import java.util.List;


public class FindUserServlet extends HttpServlet {
    private String username;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        username = req.getParameter("nameToFind");

        try (HibernateUtils hibernateUtils = new HibernateUtils()) {
            UserDAO userDAO = new HibernateUserDAO(hibernateUtils);
            List<User> foundUsers = userDAO.findByName(username);

            String title = foundUsers.size() != 0 ? "<h2>Found Users</h2>" : "<h2>No Users were found</h2>";
            StringBuilder resultTable = new StringBuilder(title);
            resultTable.append("<table border='1'>")
                    .append("<tr><th>")
                    .append("id")
                    .append("</th><th>")
                    .append("username")
                    .append("</th><th>")
                    .append("e-mail")
                    .append("</th><th>")
                    .append("birthday")
                    .append("</th><th>")
                    .append("gender")
                    .append("</th><th>")
                    .append("language")
                    .append("</th></tr>");
            for (User user: foundUsers) {
                resultTable.append("<tr><td>")
                        .append(user.getId())
                        .append("</td><td>")
                        .append(user.getUsername())
                        .append("</td><td>")
                        .append(user.getMail())
                        .append("</td><td>")
                        .append(user.getDay() + "/" + user.getMonth() + "/" + user.getYear())
                        .append("</td><td>")
                        .append(user.getGender())
                        .append("</td><td>")
                        .append(user.getLanguage())
                        .append("</td></tr>");
            }
            resultTable.append("</table>");
            resp.getWriter().print(resultTable.toString());

        }
    }

}
