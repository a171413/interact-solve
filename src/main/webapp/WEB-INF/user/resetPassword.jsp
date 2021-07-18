<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/07/15
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>パスワード再設定画面</title>
</head>
<body>
<h2>パスワードを再設定します</h2>
<p>入力欄を全て記入してください</p>
<form action="/user/resetPassword" method="post">
    <table>
        <tr>
            <td>秘密の質問</td>
            <td>${question.getContent()}</td>
            <td><input type="text" id="answer" name="answer" /></td>
        </tr>
        <tr>
            <td>新たなパスワード</td>
            <td><input type="password" id="pass" name="pass" minlength="6" maxlength="20"></td>
        </tr>
        <tr>
            <td>新たなパスワード確認</td>
            <td><input type="password" id="passConfirm" minlength="6" maxlength="20"></td>
       </tr>
    </table>
    <input type="submit" name="button" value="再設定" oninput="CheckPassword(this)">
</form>
</body>
</html>

<script lang="js" type="text/javascript">
    function CheckPassword(input){
        let pass = document.getElementById("pass")
        let passConfirm = document.getElementById("passConfirm")

        if (pass !== passConfirm){
            input.setCustomValidity('パスワードが一致しません')
        }else{
            input.setCustomValidity('')
        }
    }
</script>
