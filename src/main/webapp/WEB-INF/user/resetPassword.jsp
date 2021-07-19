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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>パスワード再設定画面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/js/common.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Barlow:wght@400;700&family=Noto+Sans+JP:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>
<body id="content">
    <div class="wrap">
        <header class="header">
            <h1 class="header-ttl">再設定</h1>
            <small class="header-en">RESET</small>
        </header>
        <main class="container">
            <div class="container-inner">
                <div class="welcome-mes">
                    <p>秘密の質問への回答と<br>新たなパスワードを入力してください</p>
                </div>
                <form action="/user/resetPassword" method="post">
                    <ul>
                        <li><p>${question.getContent()}</p><input type="text" id="answer" name="answer" /></li>
                        <li><p>新たなパスワード<br>（半角英数6文字以上20文字以下）</p><input type="password" id="pass" name="pass" minlength="6" maxlength="20"></li>
                        <li><p>新たなパスワード（確認用）</p><input type="password" id="passConfirm" minlength="6" maxlength="20"></li>
                    </ul>
                    <div class="form-btn"><button type="submit" name="button" oninput="CheckPassword(this)">再設定</button></div>
                </form>
            </div>
        </main>
        <footer class="footer">
            <div class="footer-copy">&copy; Tokyo Gakugei University.</div>
        </footer>
    </div>
</body>
