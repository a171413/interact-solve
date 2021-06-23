<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/23
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import.jsp"%>
<html>
<head>
    <title>入室手続き</title>
</head>
<body>
<h1>入室手続きを行います．ユーザーを選んでください</h1>
<h2>もしここに表示されていない場合はスマートフォンからログインを行ってから再度手続きを行ってください</h2>
<form action="/status/change" method="post">
    <c:forEach var="user" items="${isWorkingUsers}">
        <input type="radio" name="usersId" value="${user.getId()}"><c:out value="${user.getName()}" />
    </c:forEach>
    <select name="statusesId">
        <c:forEach var="status" items="${statuses}">
            <option value="${status.getId()}"><c:out value="${status.getDescription()}"/></option>
        </c:forEach>
    </select>
    <input type="submit" value="入室" />
</form>

</body>
</html>
