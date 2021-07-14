<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/06/29
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import.jsp"%>
<html>
<head>
    <title>入室状態変更</title>
</head>
<body>
<h1>入室状態の変更を行います．現在のあなたの状態を選択してください</h1>
<form action="/enter/change" method="post">
    <select name="statusesId">
        <c:forEach var="status" items="${statuses}">
            <option value="${status.getId()}"><c:out value="${status.getDescription()}"/></option>
        </c:forEach>
    </select>
    <input type="submit" value="入室" />
</form>

</body>
</html>