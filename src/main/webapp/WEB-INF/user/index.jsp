<%@ page import="model.user.User" %><%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/21
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import.jsp"%>
<%
    User currentUser = (User) session.getAttribute("currentUser");
%>
<html>
<head>
    <title>ログイン完了画面</title>
</head>
<body>
    <a href="/sessions/delete">ログアウト</a>
    <h1>ここに来ていればログインは完了です</h1>
    名前：<c:out value="${currentUser.getName()}"/><br>
    作成日：${Format.formatTimestamp(currentUser.getCreatedAt(), "yyyy年MM月dd日")}<br>

    <a href="/consultations/new">お悩みの新規登録はこちら</a><br>
    <a href="/consultations/index">お悩み一覧はこちら</a>

</body>
</html>
