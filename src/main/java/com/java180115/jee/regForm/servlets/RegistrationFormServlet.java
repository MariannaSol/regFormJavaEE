package com.java180115.jee.regForm.servlets;

import com.java180115.jee.regForm.dataValidator.Validator;
import com.java180115.jee.regForm.entities.User;
import com.java180115.jee.regForm.service.db.DAO.hibernate.HibernateUserDAO;
import com.java180115.jee.regForm.service.db.DAO.hibernate.UserDAO;
import com.java180115.jee.regForm.utils.HibernateUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationFormServlet extends HttpServlet {
    private String login;
    private String password;
    private String mail;
    private String day;
    private String month;
    private String year;
    private String gender;
    private String language;
    private String answer;
    private boolean saveOk;
    private User user;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        login = req.getParameter("username");
        password = req.getParameter("pass");
        mail = req.getParameter("mail");
        day = req.getParameter("day");
        month = req.getParameter("month");
        year = req.getParameter("year");
        gender = req.getParameter("gender");
        language = req.getParameter("language");
        answer = req.getParameter("option1");

        Validator validator = new Validator();
        boolean validLogin = validator.loginValidate(login);
        boolean validPass = validator.passwordValidate(password);
        boolean validMail = validator.mailValidate(mail);
        boolean validDate = validator.dayValidate(day, month, year);
        boolean validTerms = validator.termsCheckValidate(answer);

        String error = "";

        if (validLogin && validPass && validMail && validDate && validTerms  == true) {
            resp.getWriter().print("<font color=#009900> OK </font><br>");
            init();

            String result;
            if (saveOk == true) {
                result = "Saved into the database successfully.";
            } else result = "Error saving into the database";
            resp.getWriter().print(result);
        }
        else if (validLogin == false) {
            error = "Login is incorrect. Valid characters [a-z0-9'_-] and 3 < length < 15";
        }
        else if (validPass == false) {
            error = "Password is incorrect. Valid characters [a-z0-9@&-_#] and 6 < length < 15";
        }
        else if (validMail == false) {
            error = "E-mail is incorrect. Valid characters [0-9a-z_-]. Example username-1@ny.com";
        }
        else if (validDate == false) {
            error = "Date is incorrect or You don't have 18 years";
        }
        else if (validTerms == false) {
            error = "Please, accept the terms";
        }

        resp.getWriter().print("<font color=#CC0000>" + error + "</font>");

    }

    @Override
    public void init() throws ServletException {
        try (HibernateUtils hibernateUtils = new HibernateUtils()) {
            UserDAO userDAO = new HibernateUserDAO(hibernateUtils);
            user = new User(login, password, mail, day, month, year, gender, language);

            saveOk = userDAO.save(user);
        }
    }
}
