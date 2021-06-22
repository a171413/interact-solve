<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/23
  Time: 6:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import.jsp"%>
<html>
<head>
    <title>ようこそ</title>
</head>
<body>
    <h1>本当にログアウトして大丈夫ですか？</h1>

    <form action="/sessions/delete" method="post">
        <input type="submit" value="ログアウト" />
    </form>

    <form action="/users" method="get">
        <input type="submit" value="いいえ" />
    </form>
</body>
</html>
