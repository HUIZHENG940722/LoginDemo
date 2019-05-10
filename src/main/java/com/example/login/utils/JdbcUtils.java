package com.example.login.utils;

import java.sql.*;

/**
 * 数据连接工具类
 * @author HUIZHENG
 * @date 2019/5/7
 * @time 20:33
 * Created by IntelliJ IDEA.
 */
public class JdbcUtils {
    /**
     * 连接数据库对象
     */
    static Connection conn=null;
    /**
     * sql操作语句对象
     */
    static PreparedStatement ps=null;
    /**
     * 查询结果集对象
     */
    static ResultSet rs=null;
    /**
     * 获取数据连接
     * @return 返回一个数据连接对象
     */
    public static Connection getConn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login" ,
                    "root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据连接
     */
    public static void closeAll(){
        try{
            if (rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps!=null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (conn!=null){
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 数据查询，返回一个结果集
     * @param sql sql语句
     * @param param 参数集
     * @return 返回结果集
     */
    public static ResultSet executeQuery(String sql,String[] param){
        try {
            ps = conn.prepareStatement(sql);
            if (param!=null){
                for (int i=0;i<param.length;i++){
                    ps.setString(i+1,param[i]);
                }
            }
            rs=ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 数据查询，返回操作个数
     * @param sql sql语句
     * @param param 参数集
     * @return 操作元素个数
     */
    public static int executeUpdate(String sql,String[] param){
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            if (param!=null){
                for (int i=0;i<param.length;i++){
                    ps.setString(i+1,param[i]);
                }
            }
            num = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
}
