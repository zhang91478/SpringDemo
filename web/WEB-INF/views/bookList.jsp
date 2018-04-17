<%--
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
        <c:forEach items="${requestScope.books}" var="bookModel">
            书名：${bookModel.title}<br/>
            书号：${bookModel.isbn}<br/>
            作者：${bookModel.author}<br/>
            分类：${bookModel.kind}<br/>
            出版日期：${bookModel.publicationDate}<br/>
            价格：${bookModel.price}<br/>
            介绍：${bookModel.introduction}<br/>
            大小：${bookModel.size}<br/>
        </c:forEach>
    </c:if>

</body>
</html>
