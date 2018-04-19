<%@ page import="cn.xu419.library.model.ReaderModel" %><%--
  Created by IntelliJ IDEA.
  User: bsz
  Date: 2018/4/19
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>管理员</title>
</head>
<body>
<div>
    姓名：<%=((ReaderModel)session.getAttribute("nowUser")).getName()%>
    性别：<%=((ReaderModel)session.getAttribute("nowUser")).getSex()%>
    职位：<%=((ReaderModel)session.getAttribute("nowUser")).getPosition()%>
    账号：<%=((ReaderModel)session.getAttribute("nowUser")).getAccount()%>
    邮箱：<%=((ReaderModel)session.getAttribute("nowUser")).getEmail()%>
    <a href="/index">点击返回</a>
</div>
<div>
    <c:if test="${!empty requestScope.allUser}">
        <c:forEach items="${requestScope.allUser}" var="user">
            姓名：${user.name}
            性别：${user.sex}
            职位：${user.position}
            账号：${user.account}
            邮箱：${user.email}
            <form action="../manage" method="post">
                <input type="hidden" name="_method" value="DELETE" />
                <input type="hidden" name="account"
                       value="${user.account}">
                <input type="submit" value="点击删除">
            </form>
        </c:forEach>
    </c:if>

</div>
</body>
</html>
