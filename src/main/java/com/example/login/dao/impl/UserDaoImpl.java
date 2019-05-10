package com.example.login.dao.impl;

import com.example.login.bean.User;
import com.example.login.dao.UserDao;
import com.example.login.utils.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;


/**
 * @author HUIZHENG
 * @date 2019/5/7
 * @time 20:32
 * Created by IntelliJ IDEA.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void insertUser(User user) {
        //获取数据连接
        JdbcUtils.getConn();
        String sql="insert into tb_user values(?,?,?,?,?)";
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            JdbcUtils.executeUpdate(sql,new String[]{user.getId(),user.getUserName(),user.getUserPwd(),
                    user.getEmail(),user.getBirthday().toString()});
    }

    @Override
    public User queryUser(String userName,String userPwd) {
        String sql="select * from tb_user where userName= ? and userPwd= ?";
        JdbcUtils.getConn();
        ResultSet rs = JdbcUtils.executeQuery(sql, new String[]{userName,userPwd});
        User user=new User();

        try {
            if (rs.next()) {
                user.setId(rs.getString(1));
                user.setUserName(rs.getString(2));
                user.setUserPwd(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setBirthday(rs.getDate(5));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
