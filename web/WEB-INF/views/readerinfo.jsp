<%@ page import="cn.xu419.library.model.ReaderModel" %><%--
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
        姓名：<%=((ReaderModel)session.getAttribute("nowUser")).getName()%>
        性别：<%=((ReaderModel)session.getAttribute("nowUser")).getSex()%>
        职位：<%=((ReaderModel)session.getAttribute("nowUser")).getPosition()%>
        账号：<%=((ReaderModel)session.getAttribute("nowUser")).getAccount()%>
        邮箱：<%=((ReaderModel)session.getAttribute("nowUser")).getEmail()%>
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
    <c:if test="${empty requestScope.lendInfo}">
        您还没有借过任何书籍
    </c:if>
    <div>
        <c:if test="${!empty requestScope.lendInfo}">
            <c:forEach items="${requestScope.lendInfo}" var="record">
                <div>
                    ISBN名：${record.isbn}<br/>
                    借书时间：${record.lendTime}<br/>
                    <c:choose>
                        <c:when test="${record.lendTime eq record.returnTime}">
                            <form action="../record" method="post">
                                <input type="hidden" name="_method" value="delete" />
                                <input type="hidden" name="account"
                                       value="<%=((ReaderModel)session.getAttribute("nowUser")).getAccount()%>">
                                <input type="hidden" name="isbn" value="${record.isbn}">
                                <input type="hidden" name="lendTime" value="${record.lendTime}">
                                <input type="hidden" name="returnTime" value="${record.returnTime}">
                                <input type="submit" value="点击归还">
                            </form>
                        </c:when>
                        <c:otherwise>
                            归还时间：${record.returnTime}<br/>
                        </c:otherwise>
                    </c:choose>
                    <br/>
                </div>
            </c:forEach>
        </c:if>
    </div>

    <div>
        <c:if test="${!empty requestScope.lendInfo}">
            <c:forEach items="${requestScope.lendBookInfo}" var="book">
                <div>
                    书名：${book.title}<br/>
                    书号：${book.isbn}<br/>
                    作者：${book.author}<br/>
                    出版社：${book.press}<br/>
                    出版日期：${book.publicationDate}<br/>
                    价格：${book.price}<br/>
                    介绍：${book.introduction}<br/>
                    大小：${book.size}<br/>
                </div>
            </c:forEach>
        </c:if>
    </div>

</body>

</html>