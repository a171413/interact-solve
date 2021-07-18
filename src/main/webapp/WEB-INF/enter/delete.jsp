<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/29
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import.jsp"%>
<!doctype html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<title>入室状態変更</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/common.js"></script>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@400;700&family=Noto+Sans+JP:wght@400;700&display=swap" rel="stylesheet">
</head>
<body id="content" class="room">
	<div class="wrap">
		<header class="header">
			<h1 class="header-ttl">入室状態変更</h1>
			<small class="header-en">CHANGE</small>
			<div id="menu" class="header-menu"><span></span><span></span></div>
			<nav class="header-nav">
				<ul>
					<li class="entry-btn"><a href="/consultation/new"><i class="icon-tr"></i>タネを登録</a></li>
					<li class="entry-list"><a href="/consultation/index"><i class="icon-tr"></i>みんなのタネを見る</a></li>
					<li><a href="/enter/new"><i class="icon-tr"></i>入室設定</a></li>
					<li><a href="/enter/change"><i class="icon-tr"></i>状態変更</a></li>
					<li><a href="/enter/delete"><i class="icon-tr"></i>退室設定</a></li>
					<li><a href="/users"><i class="icon-tr"></i>マイページ</a></li>
					<li><a href="/sessions/delete"><i class="icon-tr"></i>ログアウト</a></li>
				</ul>
			</nav>
		</header><!-- ▲ header -->
		<main class="container">
			<div class="container-inner">
				<div class="welcome-mes">
					<figure class="user-fig"><img src="${pageContext.request.contextPath}/img/sample.png" alt="${currentUser.getName()}さん"/></figure>
					<p>${currentUser.getName()}さん<br>退室手続きを行いますか？</p>
				</div>
				<ul class="select-ul">
					<li>
						<form action="/users" method="get">
							<button type="submit" value="いいえ" class="outline-btn">いいえ</button>
						</form>
					</li>
					<li>
						<form action="/enter/delete" method="post">
							<button type="submit" value="はい">はい</button>
						</form>
					</li>
				</ul>
			</div>
		</main>
		<footer class="footer">
			<div class="footer-copy">&copy; Tokyo Gakugei University.</div>
		</footer>
	</div>
</body>
</html>
