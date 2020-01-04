<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="main.java.database.entities.TestDrive" %>
<%@ page import="java.util.List" %>
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
            <th>Brand</th>
            <th>Client Name</th>
            <th>Client Surname</th>
            <th>Date</th>
        </tr>

        <% List<TestDrive> testDriveList = (List) request.getAttribute("testDriveList");
            if (testDriveList != null) {
                for (int i = 0; i < testDriveList.size(); i++) {
        %>
        <tr>
            <td align="center"><%=testDriveList.get(i).getCarId()%>
            </td>
            <td align="center"><%=testDriveList.get(i).getCarBrand()%>
            </td>
            <td align="center"><%=testDriveList.get(i).getClientName()%>
            </td>
            <td align="center"><%=testDriveList.get(i).getClientSurname()%>
            </td>
            <td align="center"><%=testDriveList.get(i).getDate()%>
            </td>
            <td align="center"><a
                    href="deletetestdrive?carId=<%=testDriveList.get(i).getCarId()%>&date=<%="'" + testDriveList.get(i).getDate() + "'"%>"><img
                    src="source/cross.svg" class="icon noBorders"></a></td>
        </tr>
        <%
                }
            }
        %>

    </table>
</div>

<a href="loadtestdrive" class="addCarPurchaseAgreement">
    <button class="mainPageButton">Add</button>
</a>

<footer>
    <div id="foot">
        ©Mozgov
    </div>
</footer>

</body>
</html>