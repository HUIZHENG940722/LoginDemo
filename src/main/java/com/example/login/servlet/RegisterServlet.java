package com.example.login.servlet;

import com.example.login.bean.RegisterForm;
import com.example.login.bean.User;
import com.example.login.dao.UserDao;
import com.example.login.dao.impl.UserDaoImpl;
import com.example.login.utils.WebUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.apache.commons.beanutils.BeanUtils.copyProperties;

/**
 * 注册实现控制器
 * @author HUIZHENG
 * @date 2019/5/8
 * @time 10:20
 * Created by IntelliJ IDEA.
 */
@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码
        req.setCharacterEncoding("utf-8");
        //设置响应文本格式与相应的编码格式
        resp.setContentType("text/html;charset=utf-8");
        //将表单提交的数据封装在RegisterForm类中
        RegisterForm registerForm = WebUtils.request2Bean(req, RegisterForm.class);
        //表单校验失败
        if (registerForm.validate()==false){
            //将数据封装返回
            req.setAttribute("registerForm",registerForm);
            //校验失败就说明是用户填写的表单数据有问题，那么就跳转回register.jsp
            req.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(req,resp);
            return;
        }

        User user=new User();
        try {
            /*ConvertUtils.register(new Converter() {

                @Override
                public Object convert(Class type, Object value) {


                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        return simpleDateFormat.parse(value.toString());
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    return null;
                }
            },Date.class);*/

            // 注册字符串到日期的转换器
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            //把表单数据填充到javabean中
            copyProperties(user,registerForm);
            //设置user主键id
            user.setId(WebUtils.makeId());

            UserDao userDao=new UserDaoImpl();
            //插入用户
            userDao.insertUser(user);

            String message=String.format("注册成功！！！3秒后为您自动跳转到登录页面！！<meta http-equiv='refresh' " +
                    "content='3;url=%s'",req.getContextPath()+"/loginUi");
            req.setAttribute("message",message);
            req.getRequestDispatcher("/message.jsp").forward(req,resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
