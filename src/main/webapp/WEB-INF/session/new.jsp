<%@ page import="model.user.User" %><%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/21
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import.jsp"%>
<html>
<head>
    <title>ようこそ</title>
    <meta name="viewport" content="width=device-width,user-scalable=no,maximum-scale=1" />
</head>
<body>
    <h1>
       ようこそ　いごこラボの部屋へ
    </h1>
    <h2>まずはログインをお願いします</h2>
    <form action="/sessions/new" method="post">
        <table>
            <tr>
                <td>メールアドレス</td>
                <td><input type="email" id="mail" name="mail" required /></td>
            </tr>
            <tr>
                <td>パスワード</td>
                <td><input type="password" id="pass" name="pass" minlength="6" maxlength="20"></td>
            </tr>
        </table>
        <input type="submit" name="button" value="ログイン">
    </form>

    <u><a href="/user/forget">パスワードをお忘れの方はこちら</a></u>
</body>
</html>
