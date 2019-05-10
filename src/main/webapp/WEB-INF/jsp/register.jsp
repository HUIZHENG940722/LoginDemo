<%--
  Created by IntelliJ IDEA.
  User: HUIZHENG
  Date: 2019/5/7
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <form action="register" method="post">
        用户名:<input name="userName" type="text" value="${registerForm.errors.userName}">${registerForm.errors.userName}<br>
        密码:<input name="userPwd" type="password" value="${registerForm.errors.userPwd}">${registerForm.errors.userPwd}<br>
        确定密码:<input name="secondUserPwd" type="password" value="${registerForm.errors.secondUserPwd}">${registerForm.errors.secondUserPwd}<br>
        邮箱:<input name="email" type="email" value="${registerForm.errors.email}">${registerForm.errors.email}<br>
        生日:<input name="birthday" type="text" value="${registerForm.errors.birthday}">${registerForm.errors.birthday}<br>
        <input type="submit" value="注册"><input type="reset" value="清空"><br>
    </form>
</body>
</html>
