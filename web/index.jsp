<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: bsz
  Date: 2018/3/25
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>图书查询系统</title>
      <style>
          .searchBox{
              margin: auto auto auto auto;
          }
          .login{
              margin: auto auto auto auto;
          }
      </style>
  </head>
  <body>
  <div class="searchBox">
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
  <div class="login">
      <form action="#">
          <input type="text" name="account" placeholder="账户"><br/>
          <input type="password" name="password" placeholder="密码"><br/>
          <input type="submit" value="登陆" style="margin: auto">
      </form>
      <a href="#">注册</a>
      <a href="books?search=完&&searchType=title">调试用</a>
  </div>
  </body>
</html>
