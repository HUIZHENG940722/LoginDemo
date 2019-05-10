package com.example.login.bean;

import java.sql.Date;

/**
 * 用户实体类
 * @author HUIZHENG
 * @date 2019/5/7
 * @time 20:28
 * Created by IntelliJ IDEA.
 */
public class User {
    /**
     * 用户ID
     */
    private String id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPwd;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户生日
     */
    private Date birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
