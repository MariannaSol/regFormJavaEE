package com.java180115.jee.regForm.dataValidator;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator implements DataValidator{
    private static final String LOGIN_REG_EXP = "^[a-z0-9'_-]{3,15}$";
    private static final String PASS_REG_EXP = "^[a-z0-9@&-_#]{6,15}$";
    private static final String EMAIL_REG_EXP = "^[a-z]+[0-9a-z_-]+@[0-9a-z]+\\.[a-z]{2,5}$";
    private static final String DAY_MONTH_REG_EXP = "^[0-9]{1,2}$";
    private static final String YEAR_REG_EXP = "^[0-9]{4,4}$";

    private static final Integer FIRST_DAY_OF_MONTH = 1;
    private static final Integer LAST_DAY_OF_MONTH = 31;
    private static final Integer JANUARY = 0;
    private static final Integer DECEMBER = 11;
    private static final Integer MIN_YEAR = 1930;

    Pattern loginPattern;
    Pattern passwordPattern;
    Pattern emailPattern;
    Pattern datePattern;
    Pattern yearPattern;

    public Validator() {
        loginPattern = Pattern.compile(LOGIN_REG_EXP);
        passwordPattern = Pattern.compile(PASS_REG_EXP);
        emailPattern = Pattern.compile(EMAIL_REG_EXP);
        datePattern = Pattern.compile(DAY_MONTH_REG_EXP);
        yearPattern = Pattern.compile(YEAR_REG_EXP);
    }

    @Override
    public boolean loginValidate(String login) {
        Matcher matcher = loginPattern.matcher(login);

        return matcher.matches();
    }

    @Override
    public boolean passwordValidate(String pass) {
        Matcher matcher = passwordPattern.matcher(pass);

        return matcher.matches();
    }

    @Override
    public boolean mailValidate(String mail) {
        Matcher matcher = emailPattern.matcher(mail);
        return matcher.matches();
    }

    @Override
    public boolean dayValidate(String day, String month, String year) {
        boolean res = false;
        Matcher matcher = datePattern.matcher(day);
        if(matcher.matches() == true && ageCorrect(day, month, year) == true) {
            res = true;
        }

        return res;
    }

    @Override
    public boolean termsCheckValidate(String checked) {
        boolean res = false;
        if (checked == null) {
            res = false;
        } else if (checked.equals("yes")) {
            res = true;
         }

        return res;
    }

    @Override
    public boolean dayCorrect(String day) {
        boolean res = false;
        int dayInt = Integer.parseInt(day);

        if(dayInt >= FIRST_DAY_OF_MONTH && dayInt <= LAST_DAY_OF_MONTH) {
            res = true;
        }

        return res;
    }

    @Override
    public boolean monthCorrect(String month) {
        boolean res = false;
        int monthInt = Integer.parseInt(month);

        if(monthInt >= JANUARY && monthInt <= DECEMBER) {
            res = true;
        }

        return res;
    }

    @Override
    public boolean yearCorrect(String year) {
        boolean res = false;
        int yearInt = Integer.parseInt(year);
        GregorianCalendar calendar = new GregorianCalendar();

        if(yearInt >= MIN_YEAR && yearInt <= (calendar.get(Calendar.YEAR)-18)) {
            res = true;
        }

        return res;
    }

    @Override
    public boolean ageCorrect(String day, String month, String year) {
        boolean res = false;

        int yearInt = Integer.parseInt(year);
        int monthInt = Integer.parseInt(month);
        int dayInt = Integer.parseInt(day);

        GregorianCalendar calendar = new GregorianCalendar();

        if(dayCorrect(day) && monthCorrect(month) && yearCorrect(year) == true) {

            if((calendar.get(Calendar.YEAR)-18) >= yearInt) {
                res = true;

                if((calendar.get(Calendar.YEAR)-18) == yearInt) {

                    if(dayInt <= calendar.get(Calendar.DAY_OF_MONTH) && monthInt <= calendar.get(Calendar.MONTH)) {
                        res = true;
                    } else res = false;
                }
            } else res = false;
        }

        return res;
    }

}
