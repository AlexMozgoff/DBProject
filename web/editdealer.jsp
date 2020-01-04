<%@ page import="main.java.logic.Logic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css" type="text/css">
    <link rel="shortcut icon" href="favicon.png" type="image/png">
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>

<hr noshade id="line1">
<hr noshade id="line2">

<header>
    <div class="logo"><a href="mainpage">CarTrade</a></div>
    <ul class="menu">
        <li><a href="exit" class="link">Выход</a></li>
    </ul>
    </div>
</header>

<div class="space center"></div>

<div class="center label textCenter">Update Dealer</div>

<form action="update" method="get" class="center">

    <div class="regTextboxes">

        <div class="field">
            <label for "surname" class="label">Surname</label>
            <input class="input" name="surname" value="<%=Logic.replaceSpace(request.getParameter("surname"))%>"/>
        </div>

        <div class="field">
            <label for "name" class="label">Name</label>
            <input class="input" name="name" value="<%=Logic.replaceSpace(request.getParameter("name"))%>"/>
        </div>

        <div class="field">
            <label for "patronymic" class="label">Patronymic</label>
            <input class="input" name="patronymic" value="<%=Logic.replaceSpace(request.getParameter("patronymic"))%>"/>
        </div>

        <div class="field">
            <label for "address" class="label">Address</label>
            <input class="input" name="address" value="<%=Logic.replaceSpace(request.getParameter("address"))%>"/>
        </div>

        <div class="field">
            <label for "phone" class="label">Phone</label>
            <input class="input" name="phone" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
                   required placeholder = "927-123-4567" value="<%=Logic.replaceSpace(request.getParameter("phone"))%>"/>
        </div>

        <div class="hidden">
            <label></label>
            <input name="dealerId" value="<%=Integer.parseInt(request.getAttribute("dealerId").toString())%>"/>
            <input name="operation" value="<%=request.getAttribute("operation").toString()%>"/>
        </div>
        <input class="mainPageButton" type="submit" value="Update"></input>

    </div>


</form>

<footer>
    <div id="foot">
        ©Mozgov
    </div>
</footer>

</body>
</html>
