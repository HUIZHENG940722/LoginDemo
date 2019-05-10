package com.example.login.dao;

import com.example.login.bean.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author HUIZHENG
 * @date 2019/5/7
 * @time 20:32
 * Created by IntelliJ IDEA.
 */
public interface UserDao {
    /**
     * 插入用户
     * @param user 用户实体
     */
    void insertUser(User user);

    /**
     * 根据用户名查找用户
     * @param userName 用户名
     * @param userPwd 密码
     * @return 找到的用户
     * @throws
     */
    User queryUser(String userName,String userPwd) throws SQLException;
}
