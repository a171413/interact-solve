<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/19
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新規ユーザー情報登録</title>
</head>
<body>
    <p>ユーザー情報を入力してください</p>
    <form action="/user/signup" method="post">
        <table>
            <tr>
                <td>氏名</td>
                <td><input type="text" name="name" required /></td>
            </tr>
            <tr>
                <td>メールアドレス</td>
                <td><input type="email" id="mail" name="mail" required /></td>
            </tr>
            <tr>
                <td>メールアドレス確認用</td>
                <td><input type="email" id="mailConfirm" required oninput="CheckEmail(this)"/></td>
            </tr>
            <tr>
                <td>パスワード</td>
                <td><input type="password" id="pass" name="pass" minlength="6" maxlength="20"></td>
            </tr>
            <tr>
                <td>パスワード確認</td>
                <td><input type="password" id="passConfirm" minlength="6" maxlength="20"></td>
            </tr>
        </table>
        <input type="submit" name="button" value="登録" oninput="CheckPassword(this)">
    </form>
</body>
</html>

<script lang="js" type="text/javascript">
    function CheckEmail(input){
        let mail = document.getElementById("mail")
        let mailConfirm = document.getElementById("mailConfirm")

        println(mail)
        println(mailConfirm)

        if (mail !== mailConfirm){
            input.setCustomValidity('メールアドレスが一致しません')
        }else{
            input.setCustomValidity('')
        }
    }

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
