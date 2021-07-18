<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/07/14
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>本人確認</title>
</head>
<body>
<form action="/user/forget" method="post">
    <table>
        <tr>
            <td>メールアドレス</td>
            <td><input type="email" id="mail" name="mail" required /></td>
        </tr>
        <tr>
            <td>誕生日</td>
            <td><input type="date" id="birthday" name="birthday" required /></td>
        </tr>
    </table>
    <c:if test="${couldNotUpdate}">
        <script>
            alert('メールアドレスまたは誕生日が間違えています');
        </script>
    </c:if>
    <input type="submit" name="button" value="送信">
</form>
</body>
</html>
