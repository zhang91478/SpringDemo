<%--
  Created by IntelliJ IDEA.
  User: bsz
  Date: 2018/4/18
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
    <div>
        <c:if test="${!empty requestScope.nowUser}">
            姓名：${requestScope.nowUser.name}
            性别：${requestScope.nowUser.sex}
            职位：${requestScope.nowUser.position}
            账号：${requestScope.nowUser.account}
            邮箱：${requestScope.nowUser.email}
        </c:if>
        <a href="/index">点击返回</a>
    </div>

    <div>
        <form action="/books">
            <label>
                <select name="searchType">
                    <option value="title">书名</option>
                    <option value="author">作者</option>
                    <option value="isbn">ISBN</option>
                </select>
            </label>
            <label>
                <input type="text" name="search" placeholder="请选择查询方式，默认以书名查询">
            </label>
            <input type="submit" value="查询">
        </form>
    </div>
    <c:if test="${!empty requestScope.lendInfo}">
        您还没有借过任何书籍
    </c:if>
    <%--<div>--%>
        <%--<c:if test="${!empty requestScope.lendInfo}">--%>
            <%--<c:forEach items="${requestScope.lendInfo}" var="record">--%>
                <%--<div>--%>
                    <%--ISBN名：${record.title}<br/>--%>
                    <%--借书时间：${record.isbn}<br/>--%>
                    <%--归还时间：${record.author}<br/>--%>
                <%--</div>--%>
            <%--</c:forEach>--%>
        <%--</c:if>--%>
    <%--</div>--%>

    <%--<div>--%>
        <%--<c:if test="${!empty requestScope.lendInfo}">--%>
            <%--<c:forEach items="${requestScope.lendBookInfo}" var="book">--%>
                <%--<div>--%>
                    <%--书名：${book.title}<br/>--%>
                    <%--书号：${book.isbn}<br/>--%>
                    <%--作者：${book.author}<br/>--%>
                    <%--出版社：${book.press}<br/>--%>
                    <%--出版日期：${book.publicationDate}<br/>--%>
                    <%--价格：${book.price}<br/>--%>
                    <%--介绍：${book.introduction}<br/>--%>
                    <%--大小：${book.size}<br/>--%>
                <%--</div>--%>
            <%--</c:forEach>--%>
        <%--</c:if>--%>
    <%--</div>--%>

</body>

</html>