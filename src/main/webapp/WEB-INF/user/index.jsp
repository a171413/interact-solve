<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/21
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import.jsp"%>
<html>
<head>
    <title>ログイン完了画面</title>
    <meta name="viewport" content="width=device-width,user-scalable=no,maximum-scale=1" />
</head>
<body>
    <%@ include file="../common/hamburger.jsp"%>
    <h1>マイページ</h1>
    名前：<c:out value="${currentUser.getName()}"/><br>
    作成日：${Format.formatTimestamp(currentUser.getCreatedAt(), "yyyy年MM月dd日")}<br>

    <a href="/enter/new">入室手続きはこちらから</a><br>
    <a href="/consultations/new">タネの新規登録はこちら</a><br>
    <a href="/consultations/index">タネ一覧はこちら</a>

    <h2>現在の部屋の入室状況</h2>
    <table>
        <tr>
            <th>状況</th><th>人数</th>
        </tr>
        <c:forEach var="status" items="${statuses}">
            <tr>
                <td>
                    ${status.getDescription()}
                </td>
                <td>
                    ${enters[status.getId()]}人
                </td>
            </tr>
        </c:forEach>
    </table>


    <h3>あなたがこれまでに投稿した質問はこちら</h3>
    <table>
        <tr>
            <th>タイトル</th><th>内容</th><th>投稿日時</th>
        </tr>
        <c:forEach var="consultation" items="${myConsultations}">
            <tr>
                <td><a href="/consultations/detail?id=${consultation.getId()}">${consultation.getTitle()}</a></td>
                <td>${consultation.getDetail()}</td>
                <td>${consultation.getContributor().getCreatedAt()}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
