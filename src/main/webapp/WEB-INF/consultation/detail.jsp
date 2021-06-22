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
<html>
<head>
    <title>お悩み詳細</title>
</head>
<body>
    <h1>ここは${consultation.getTitle()}についての詳細画面です</h1>
    <h2>詳細</h2>
    <table>
        <tr>
            <th>内容</th><th>投稿者</th>
        </tr>
        <tr>
            <td>
                ${consultation.getDetail()}
            </td>
            <td>
                ${consultation.contributor.getName()}
            </td>
        </tr>
    </table>

    <form action="/replies/new?consultations_id=${consultation.getId()}" method="post">
        <textarea name="content"></textarea>
        <input type="submit" value="送信" />
    </form>

    <h2>コメント</h2>
    <table>
        <tr>
            <th>内容</th><th>投稿者</th><th>投稿時間</th>
        </tr>
        <c:forEach var="reply" items="${replies}">
            <tr>
                <td><c:out value="${reply.getContent()}"/></td>
                <td>
                    <c:url value="/users/detail" var = "aURL">
                        <c:param name="usersId" value="${reply.getReplier().getId()}"/>
                        <c:param name="usersName" value="${reply.getReplier().getName()}"/>
                    </c:url>
                    <a href="${aURL}">${reply.getReplier().getName()}</a>
                </td>
                <td>${reply.getCreatedAt()}</td>
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
