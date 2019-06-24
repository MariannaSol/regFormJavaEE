package com.java180115.jee.regForm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;

    private String username;

    private String password;

    @Column(unique = true)
    private String mail;

    private String day;
    private String month;
    private String year;

    private String gender;

    private String language;


    public User(String username, String password, String mail, String day,
                String month, String year, String gender, String language) {
        setUsername(username);
        setPassword(password);
        setMail(mail);
        setDay(day);
        setMonth(month);
        setYear(year);
        setGender(gender);
        setLanguage(language);
    }

    public User() {
        username = "Unknown";
        password = "Unknown";
        mail = "Unknown";
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password != null) {
            this.password = password;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username != null) {
            this.username = username;
        }
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        if(mail != null) {
            this.mail = mail;
        }
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender != null) {
            this.gender = gender;
        }
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        if (language != null) {
            this.language = language;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (day != null ? !day.equals(user.day) : user.day != null) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        if (language != null ? !language.equals(user.language) : user.language != null) return false;
        if (mail != null ? !mail.equals(user.mail) : user.mail != null) return false;
        if (month != null ? !month.equals(user.month) : user.month != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (year != null ? !year.equals(user.year) : user.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (day != null ? day.hashCode() : 0);
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", gender='" + gender + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
