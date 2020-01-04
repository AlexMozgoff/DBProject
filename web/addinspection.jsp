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

<div class="center label textCenter">Add Inspection</div>

<form action="addinspection" method="get" class="center">

    <div class="regTextboxes fillBottom">

        <select class="selectorId field" name="carId">
            <%
                Map<Integer, String> cars = (Map<Integer, String>) request.getAttribute("cars");
                for (int i = 0; i < cars.size(); i++) {%>
            <option><%=cars.values().toArray()[i]%>
            </option>
            <%}%>
        </select>

        <div class="field">
            <label for "date" class="label">Date</label>
            <input class="input" name="date" pattern="[0-9]{4}.[0-9]{2}.[0-9]{2}" required
                   placeholder="2019.12.31"/>
        </div>

        <div class="field">
            <label for "mileage" class="label">Mileage</label>
            <input class="input" name="mileage" pattern="^[ 0-9]+$"/>
        </div>

        <div class="field">
            <label for "equipment" class="label">Equipment</label>
            <input class="input" name="equipment">
        </div>

        <div class="field">
            <label for "seats" class="label">Seats</label>
            <input class="input" name="seats" pattern="[0-9]{1,2}">
        </div>

        <div class="field">
            <label for "numberOfOwners" class="label">NumberOfOwners</label>
            <input class="input" name="numberOfOwners" pattern="[0-9]{1,2}">
        </div>

        <div class="field">
            <label for "gearbox" class="label">Gearbox</label>
            <input class="input" name="gearbox">
        </div>

        <div class="field">
            <label for "engineVolume" class="label">Engine Volume</label>
            <input class="input" name="engineVolume">
        </div>

        <div class="field">
            <label for "vin" class="label">VIN</label>
            <input class="input" name="vin">
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
