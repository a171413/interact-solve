<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/19
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<title>新規ユーザー登録</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	<script src="${pageContext.request.contextPath}/js/common.js"></script>
	<script src="${pageContext.request.contextPath}/js/nullify-enter.js"></script>
	<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@400;700&family=Noto+Sans+JP:wght@400;700&display=swap" rel="stylesheet">
</head>

<body id="content">
	<div class="wrap">
		<header class="header">
			<h1 class="header-ttl">新規登録</h1>
			<small class="header-en">ENTRY</small>
		</header><!-- ▲ header -->
		<main class="container">
			<div class="container-inner">
				<div class="welcome-mes">
					<p>ユーザー情報を入力してください</p>
					<p>（ログインの方は<a href="/sessions/new">こちら</a>）</p>
				</div>
				<form action="/user/signup" method="post" id="form1">
					<ul>
						<li><p>氏名</p><input type="text" name="name" placeholder="氏名" required /></li>
						<li><p>メールアドレス</p><input type="email" id="mail" name="mail" placeholder="メールアドレス" required /></li>
						<li><p>メールアドレス（確認用）</p><input type="email" id="mailConfirm" oninput="CheckEmail(this)" placeholder="メールアドレス確認" required /></li>
						<li><p>パスワード<br>（半角英数6文字以上20文字以内）</p><input type="password" id="pass" name="pass" minlength="6" maxlength="20" placeholder="パスワード"></li>
						<li><p>パスワード（確認用）</p><input type="password" id="passConfirm" minlength="6" maxlength="20" placeholder="パスワード確認"></li>
                        <li><p>誕生日</p><input type="date" id="birthday" name="birthday" required /></li>
						<li>
							<p>秘密の質問</p>
                            <div class="form-select">
                                <select name="question">
                                    <c:forEach var="question" items="${questions}">
                                        <option value="${question.getId()}"><c:out value="${question.getContent()}" /></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </li>
						<li><p>秘密の質問への回答</p><input type="text" id="answer" name="answer" placeholder="質問への回答"/></li>
					</ul>
					<div class="form-btn"><button type="submit" name="button" oninput="CheckPassword(this)">登録</button></div>
				</form>
			</div>
		</main>
		<%@include file="../common/footer.jsp"%>
	</div>
</body>
</html>
