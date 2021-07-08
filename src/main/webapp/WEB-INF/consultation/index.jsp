<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/22
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/import.jsp"%>
<html>
<head>
    <title>お悩み一覧</title>
    <meta name="viewport" content="width=device-width,user-scalable=no,maximum-scale=1" />
</head>
<body>
<%@ include file="../common/hamburger.jsp"%>
    <h1>提案一覧はこちら</h1>
    <table>
        <tr>
            <th>タイトル</th><th>内容</th><th>投稿者名</th>
        </tr>
        <c:forEach var="consultation" items="${consultations}">
            <tr>
                <td><a href="/consultations/detail?id=${consultation.getId()}">${consultation.getTitle()}</a></td>
                <td>${consultation.getDetail()}</td>
                <td>${consultation.getContributor().getName()}</td>
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
