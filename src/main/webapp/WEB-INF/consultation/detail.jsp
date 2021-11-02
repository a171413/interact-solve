<%@ page import="model.reply.Reply" %>
<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/23
  Time: 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import.jsp"%>
<!doctype html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<title>${consultation.getTitle()} - タネ詳細</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/common.js"></script>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@400;700&family=Noto+Sans+JP:wght@400;700&display=swap" rel="stylesheet">
</head>
<body id="content" class="tane">
	<div class="wrap">
		<header class="header">
			<h1 class="header-ttl">タネ詳細</h1>
			<small class="header-en">TANE DETAIL</small>
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
			<div class="container-tane">
				<header>
					<i class="icon-seed"></i>
					<h2>${consultation.getTitle()}</h2>
					<figure>
						<figcaption><b>${consultation.contributor.getName()}</b>さん</figcaption>
					</figure>
				</header>
				<div class="comment">
					<p>${consultation.getDetail()}</p>
				</div>
				<form action="/replies/new?consultations_id=${consultation.getId()}" method="post">
					<textarea name="content" placeholder="こんなのはどうですか？" class="proposal"></textarea>
					<div class="form-btn"><button type="submit" value="送信">提案</button></div>
				</form>
				<div class="container-tane_proposal">
					<h3><small>CHECK!</small>みんなの提案</h3>
					<c:forEach var="reply" items="${replies}">
					<dl>
						<div>
							<dd>
								<p><c:out value="${reply.getContent()}"/></p>
								<time>${reply.getCreatedAt()}</time>
							</dd>
							<dt>
								<c:url value="/users/detail" var = "aURL">
									<c:param name="usersId" value="${reply.getReplier().getId()}"/>
									<c:param name="usersName" value="${reply.getReplier().getName()}"/>
								</c:url>
								<figure><a href="${aURL}"><img src="${pageContext.request.contextPath}/img/sample.png" alt="${reply.getReplier().getName()}さん"/></a></figure>
								<p><a href="${aURL}"><b>${reply.getReplier().getName()}</b>さん</a></p>
							</dt>
						</div>
					</dl>
					</c:forEach>
				</div>
			</div>
		</main>
		<%@include file="../common/footer.jsp"%>
	</div>
</body>
</html>
