<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/22
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提案登録画面</title>
</head>
<body>
    <a href="/sessions/delete">ログアウト</a>
    <p>提案を登録してください</p>
    <form action="/consultations/new" method="post">
        <table>
            <tr>
                <td>タイトル</td>
                <td><input type="text" name="title" required maxlength="45" /></td>
            </tr>
            <tr>
                <td>内容</td>
                <td><textarea name="detail"></textarea></td>
            </tr>
        </table>
        <input type="submit" value="登録" />
    </form>
</body>
</html>
