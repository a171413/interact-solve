<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/23
  Time: 5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<title>${userName}さんの詳細ページ</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/common.js"></script>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@400;700&family=Noto+Sans+JP:wght@400;700&display=swap" rel="stylesheet">
</head>
<body id="content" class="mypage">
	<div class="wrap">
		<header class="header">
			<h1 class="header-ttl">ユーザー詳細</h1>
			<small class="header-en">USER DETAIL</small>
			<div id="menu" class="header-menu"><span></span><span></span></div>
			<nav class="header-nav">
				<ul>
					<li class="entry-btn"><a href="/consultation/new"><i class="icon-tr"></i>タネを登録</a></li>
					<li class="entry-list"><a href="/consultation/index"><i class="icon-tr"></i>みんなのタネを見る</a></li>
					<li><a href="/enter/new"><i class="icon-tr"></i>入室設定</a></li>
					<li><a href="/enter/change"><i class="icon-tr"></i>状態変更</a></li>
					<li><a href="/enter/delete"><i class="icon-tr"></i>退室設定</a></li>
					<li><a href="/user/index"><i class="icon-tr"></i>マイページ</a></li>
					<li><a href="/sessions/delete"><i class="icon-tr"></i>ログアウト</a></li>
				</ul>
			</nav>
		</header><!-- ▲ header -->
		<main class="container">
			<section class="section-tane">
				<h3><b>${userName}</b><span>さんの</span><br>タネ一覧</h3>
				<div class="container-list">
					<c:forEach var="consultation" items="${consultations}">
					<article class="tane-article">
						<div class="inner">
							<time>${consultation.getContributor().getCreatedAt()}</time>
							<h2>${consultation.getTitle()}</h2>
							<a href="/consultation/detail?id=${consultation.getId()}">CHECK<i class="icon-tr"></i></a>
						</div>
					</article>
					</c:forEach>
				</div>
			</section>
		</main>
		<footer class="footer">
			<div class="footer-copy">&copy; Tokyo Gakugei University.</div>
		</footer>
	</div>
</body>
</html>
