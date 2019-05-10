package com.example.login.servlet;

import com.example.login.bean.User;
import com.example.login.dao.UserDao;
import com.example.login.dao.impl.UserDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author HUIZHENG
 * @date 2019/5/8
 * @time 16:52
 * Created by IntelliJ IDEA.
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String userName=req.getParameter("userName");
        String userPwd=req.getParameter("userPwd");
        UserDao userDao=new UserDaoImpl();
        try {
            User user = userDao.queryUser(userName,userPwd);
            if(user==null){
                String message = String.format(
                        "对不起，用户名或密码有误！！请重新登录！2秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='2;url=%s'",
                        req.getContextPath()+"/servlet/LoginUIServlet");
                req.setAttribute("message",message);
                req.getRequestDispatcher("/message.jsp").forward(req, resp);
                return;
            }
            //登录成功后，就将用户存储到session中
            req.getSession().setAttribute("user", user);
            String message = String.format(
                    "恭喜：%s,登陆成功！本页将在3秒后跳到首页！！<meta http-equiv='refresh' content='3;url=%s'",
                    user.getUserName(),
                    req.getContextPath()+"/index.jsp");
            req.setAttribute("message",message);
            req.getRequestDispatcher("/message.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
