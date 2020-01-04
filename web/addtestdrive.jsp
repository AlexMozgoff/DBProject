<%@ page import="java.util.Map" %>
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

<div class="center label textCenter">Add Test-drive</div>

<form action="addtestdrive" method="get" class="center">

    <div class="regTextboxes">

        <select class="selectorId field" name="carId">
            <%
                Map<Integer, String> cars = (Map<Integer, String>) request.getAttribute("cars");
                for (int i = 0; i < cars.size(); i++) {%>
            <option><%=cars.values().toArray()[i]%></option>
            <%}%>
        </select>

        <select class="selectorId field" name="clientId">
            <%
                Map<Integer, String> clients = (Map<Integer, String>) request.getAttribute("clients");
                for (int i = 0; i < clients.size(); i++) {%>
            <option><%=clients.values().toArray()[i]%></option>
            <%}%>
        </select>

        <div class="field">
            <label for "date" class="label">Date</label>
            <input class="input" name="date" pattern="[0-9]{4}.[0-9]{2}.[0-9]{2}" required
                   placeholder="2019.12.31"/>
        </div>
        <input class="mainPageButton" type="submit" value="Add"></input>
    </div>


</form>

<footer>
    <div id="foot">
        ©Mozgov
    </div>
</footer>

</body>
</html>
