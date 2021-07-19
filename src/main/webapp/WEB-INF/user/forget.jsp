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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>本人確認</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/common.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Barlow:wght@400;700&family=Noto+Sans+JP:wght@400;700&display=swap" rel="stylesheet">
</head>
<body id="content">
    <div class="wrap">
        <header class="header">
            <h1 class="header-ttl">本人確認</h1>
            <small class="header-en">IDENTIFICATION</small>
        </header>
        <main class="container">
            <div class="container-inner">
                <div class="welcome-mes">
                    <p>ユーザー情報を入力してください</p>
                </div>
                <form action="/user/forget" method="post">
                    <ul>
                        <li><p>メールアドレス</p><input type="email" id="mail" name="mail" placeholder="メールアドレス" required /></li>
                        <li><p>誕生日</p><input type="date" id="birthday" name="birthday" required /></li>
                    </ul>
                    <div class="form-btn"><button type="submit" name="button">送信</button></div>
                </form>
            </div>
        </main>
        <footer class="footer">
            <div class="footer-copy">&copy; Tokyo Gakugei University.</div>
        </footer>
    </div>
</body>
</html>
