<%--
  Created by IntelliJ IDEA.
  User: bsz
  Date: 2018/4/18
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <div>
        <form action="/register" METHOD="post">
            账户：
            <input type="text" placeholder="手机号/学号/邮箱" name="account"><br/>
            密码:
            <input type="password" placeholder="密码" name="password"><br/>
            <input type="password" placeholder="确认密码" name="checkPassWord"><br/>
            性别:
            <input type="radio" id="man" name="sex" value="man" placeholder="man">
            <label for="man">男</label>
            <input type="radio" id="woman" name="sex" value="woman" placeholder="woman">
            <label for="woman">女</label><br/>
            姓名:
            <input type="text" name="name" placeholder="姓名"><br/>
            邮箱:
            <input type="email" name="email" placeholder="123@xx.xxx"><br/>
            职位：
            <input type="radio" id="stu" name="position" value="student" >
            <label for="stu">学生</label>
            <input type="radio" id="tea" name="position" value="teacher" placeholder="教师更要多读书">
            <label for="tea">教师</label><br/>
            <input type="submit" value="提交">
        </form>
        <a href="/index">点击返回</a>
    </div>
</body>
</html>
