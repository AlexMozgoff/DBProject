<%@ page import="java.util.List" %>
<%@ page import="main.java.database.entities.Inspection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link rel="stylesheet" href="style.css" type="text/css">
    <link rel="shortcut icon" href="favicon.png" type="image/png">
    <meta charset="utf-8">
    <title>Главная страница</title>
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
<div class="center">
    <table class="dbTable">
        <tr>
            <th>Car Id</th>
            <th>Date</th>
            <th>Brand</th>
            <th>Mileage</th>
            <th>Equipment</th>
            <th>Seats</th>
            <th>Owners</th>
            <th>Gearbox</th>
            <th>Engine Volume</th>
            <th>VIN</th>
        </tr>

        <% List<Inspection> inspections = (List) request.getAttribute("inspections");
            if (inspections != null) {
                for (int i = 0; i < inspections.size(); i++) {
        %>
        <tr>
            <td align="center"><%=inspections.get(i).getCarId()%>
            </td>
            <td align="center"><%=inspections.get(i).getDate()%>
            </td>
            <td align="center"><%=inspections.get(i).getBrand()%>
            </td>
            <td align="center"><%=inspections.get(i).getMileage()%>
            </td>
            <td align="center"><%=inspections.get(i).getEquipment()%>
            </td>
            <td align="center"><%=inspections.get(i).getSeats()%>
            </td>
            <td align="center"><%=inspections.get(i).getNumberOfOwners()%>
            </td>
            <td align="center"><%=inspections.get(i).getGearbox()%>
            </td>
            <td align="center"><%=inspections.get(i).getEngineVolume()%>
            </td>
            <td align="center"><%=inspections.get(i).getVin()%>
            </td>
            <td align="center"><a href="deleteinspection?carId=<%=inspections.get(i).getCarId()%>"><img
                    src="source/cross.svg" class="icon noBorders"></a></td>
        </tr>
        <%
                }
            }
        %>

    </table>
</div>

<a href="loadinspection" class="addCarPurchaseAgreement">
    <button class="mainPageButton">Add</button>
</a>

<footer>
    <div id="foot">
        ©Mozgov
    </div>
</footer>

</body>
</html>