<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/23
  Time: 5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${userName}さんの詳細ページ</title>
</head>
<body>
    <a href="/sessions/delete">ログアウト</a>
    <h1>ここは${userName}さんの詳細ページです</h1>
    <h2>これまで${userName}さんが投稿してきたお悩みはこちら</h2>
    <table>
        <tr>
            <th>タイトル</th><th>内容</th><th>投稿日時</th>
        </tr>
        <c:forEach var="consultation" items="${consultations}">
            <tr>
                <td><a href="/consultations/detail?id=${consultation.getId()}">${consultation.getTitle()}</a></td>
                <td>${consultation.getDetail()}</td>
                <td>${consultation.getContributor().getCreatedAt()}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>

<style>
    table {
        border-collapse: collapse;
    }
    th, td {
        border: 1px solid #333;
    }
</style>
