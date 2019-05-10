<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
</head>
    <script type="text/javascript">
        function doLogout() {
            //注销页面跳转
            window.location.href="${pageContext.request.contextPath}/logout";
        }
    </script>
<body>
<h1>ethan开发的登录demo</h1><hr/>
<c:if test="${user==null}">
    <a href="${pageContext.request.contextPath}/registerUi">注册</a>
    <a href="${pageContext.request.contextPath}/loginUi">登陆</a>
</c:if>
<c:if test="${user!=null}">
    欢迎您：${user.userName}
    <input type="button" value="退出登陆" onclick="doLogout()">
</c:if>

</body>
</html>
