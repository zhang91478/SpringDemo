<%@ page import="cn.xu419.library.model.ReaderModel" %><%--
  Created by IntelliJ IDEA.
  User: bsz
  Date: 2018/4/17
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>查询结果</title>
</head>
<body>

<c:if test="${empty requestScope.books}">
    无此书籍<a href="/index">点击返回</a>
</c:if>
    <c:if test="${!empty requestScope.books}">
        <c:forEach items="${requestScope.books}" var="book">
            <form action="../record" method="post">
                <input type="hidden" name="_method" value="PUT" />
                <input type="hidden" name="account"
                       value="<%=((ReaderModel)session.getAttribute("nowUser")).getAccount()%>">
                <input type="hidden" name="isbn" value="${book.isbn}">
                书名：${book.title}<br/>
                书号：${book.isbn}<br/>
                作者：${book.author}<br/>
                出版社：${book.press}<br/>
                出版日期：${book.publicationDate}<br/>
                价格：${book.price}<br/>
                介绍：${book.introduction}<br/>
                大小：${book.size}<br/>
                <input type="submit" value="借阅本书">
            </form>
        </c:forEach>
    </c:if>
</body>
</html>
