<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/21
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import.jsp"%>
<!doctype html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<title>ログイン</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@400;700&family=Noto+Sans+JP:wght@400;700&display=swap" rel="stylesheet">
</head>
<body id="content">
	<div class="wrap">
		<header class="header">
			<h1 class="header-ttl">ログイン</h1>
			<small class="header-en">LOGIN</small>
		</header><!-- ▲ header -->
		<main class="container">
			<div class="container-inner">
				<div class="welcome-mes">
					<p>ようこそいごこラボの部屋<br>ログインしよう！</p>
				</div>
				<form action="/sessions/new" method="post">
					<ul>
						<li><input type="email" id="mail" name="mail" placeholder="メールアドレス" required /></li>
						<li><input type="password" id="pass" name="pass" minlength="6" maxlength="20" placeholder="パスワード"></li>
					</ul>
					<div class="form-btn"><button type="submit" name="button">ログイン</button></div>
				</form>
				<c:if test="${couldNotSignIn}">
					<p>※メールアドレスまたはパスワードが間違えています</p>
				</c:if>
				<div class="forget-btn">パスワードをお忘れの方は<a href="/user/forget">こちら</a></div>
			</div>
		</main>
		<footer class="footer">
			<div class="footer-copy">&copy; Tokyo Gakugei University.</div>
		</footer>
	</div>
</body>
</html>
