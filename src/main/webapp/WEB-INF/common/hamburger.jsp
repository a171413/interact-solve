<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2021/07/09
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <div class="hamburger-menu">
        <input type="checkbox" id="menu-btn-check">
        <label for="menu-btn-check" class="menu-btn"><span></span></label>
        <!--ここからメニュー-->
        <div class="menu-content">
            <ul>
                <li><a href="/users">マイページ</a></li>
                <li><a href="/enter/new">入室手続き</a></li>
                <li><a href="/enter/change">入室状態の変更</a></li>
                <li><a href="/enter/delete">退室手続き</a></li>
                <li><a href="/consultations/new">タネの登録</a></li>
                <li><a href="/consultations/index">タネの一覧</a></li>
                <li><a href="/sessions/delete">ログアウト</a></li>
            </ul>
        </div>
        <!--ここまでメニュー-->
    </div>
</header>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/header/style.css">
