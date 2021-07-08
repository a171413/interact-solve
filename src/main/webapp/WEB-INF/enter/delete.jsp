<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/29
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import.jsp"%>
<html>
<head>
    <title>退室手続き</title>
    <meta name="viewport" content="width=device-width,user-scalable=no,maximum-scale=1" />
</head>
<body>
<%@ include file="../common/hamburger.jsp"%>
<h1>退室手続きを行います．本当によろしいですか？</h1>
<form action="/enter/delete" method="post">
    <input type="submit" value="はい">
</form>
<form action="/users" method="get">
    <input type="submit" value="いいえ">
</form>
</body>
</html>
