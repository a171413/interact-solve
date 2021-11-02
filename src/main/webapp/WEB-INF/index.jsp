<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/21
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./common/import.jsp"%>
<!doctype html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<title>WELCOME</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@400;700&family=Noto+Sans+JP:wght@400;700&display=swap" rel="stylesheet">
</head>
<body id="top">
	<div class="wrap">
		<header class="header">
			<h1 class="header-logo"><i class="icon-seed"></i></h1>
			<p class="header-mes">WELCOME</p>
		</header><!-- ▲ header -->
		<main class="container">
			<p>ようこそ<br class="sp-visible"><b>"タネ"</b>共有アプリケーションへ</p>
			<ul class="container-gnav">
				<li class="signup-btn"><a href="/user/signup">新規登録</a></li>
				<li class="login-btn"><a href="/sessions/new">ログイン</a></li>
			</ul>
		</main>
		<%@include file="common/footer.jsp"%>
	</div>
</body>
</html>
