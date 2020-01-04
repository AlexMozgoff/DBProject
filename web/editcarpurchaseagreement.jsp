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

<div class="center label textCenter">Update car purchase agreement</div>

<form action="update" method="get" class="center">

    <div class="regTextboxes">

        <div class="field">
            <label for "carId" class="label">Car ID</label>
            <input class="input" name="carId" value="<%=Logic.replaceSpace(request.getParameter("carId"))%>" pattern="^[0-9]+$"/>
        </div>

        <div class="field">
            <label for "brand" class="label">Brand</label>
            <input class="input" name="brand" value="<%=Logic.replaceSpace(request.getParameter("brand"))%>"/>
        </div>

        <div class="field">
            <label for "date" class="label">Date</label>
            <input class="input" name="date" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
                   required placeholder = "2019-12-31" value="<%=Logic.replaceSpace(request.getParameter("date").replaceAll("'", ""))%>"/>
        </div>

        <div class="field">
            <label for "commission" class="label">Commission</label>
            <input class="input" name="commission" value="<%=Logic.replaceSpace(request.getParameter("commission"))%>"/>
        </div>

        <div class="field">
            <label for "remark" class="label">Remark</label>
            <input class="input" name="remark" value="<%=Logic.replaceSpace(request.getParameter("remark"))%>"/>
        </div>

        <div class="hidden">
            <label></label>
            <input name="agreementId" value="<%=Integer.parseInt(request.getAttribute("agreementId").toString())%>"/>
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
