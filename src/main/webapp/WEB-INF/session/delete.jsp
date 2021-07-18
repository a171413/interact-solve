<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/23
  Time: 6:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import.jsp"%>
<!doctype html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<title>ログアウト</title>
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
					<figure class="user-fig"><img src="${pageContext.request.contextPath}/img/sample.png" alt="Chimpuiさん"/></figure>
					<p>Chimpuiさん<br>本当にログアウトして<br>大丈夫ですか？</p>
				</div>
				<ul class="select-ul">
					<li>
						<form action="/users" method="get">
							<button type="submit" value="いいえ" class="outline-btn">いいえ</button>
						</form>
					</li>
					<li>
						<form action="/sessions/delete" method="post">
							<button type="submit" value="はい">はい</button>
						</form>
					</li>
				</ul>
				<div class="attention">
					<p>ログアウトに関する注意事項の記載。ログアウトに関する注意事項の記載。ログアウトに関する注意事項の記載。ログアウトに関する注意事項の記載。</p>
				</div>
			</div>
		</main>
		<footer class="footer">
			<div class="footer-copy">&copy; Tokyo Gakugei University.</div>
		</footer>
	</div>
</body>
</html>
