package com.java180115.jee.regForm.dataValidator;


public interface DataValidator {
    public boolean loginValidate(String login);
    public boolean passwordValidate(String pass);
    public boolean mailValidate(String mail);
    public boolean dayValidate(String day, String month, String year);
    public boolean termsCheckValidate(String checked);

    public boolean dayCorrect(String day);
    public boolean monthCorrect(String month);
    public boolean yearCorrect(String year);
    public boolean ageCorrect(String day, String month, String year);

}
