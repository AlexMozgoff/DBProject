<%@ page import="java.util.List" %>
<%@ page import="main.java.database.objects.Inspection" %>
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
	<div class="logo">CarTrade</div>
	<ul class="menu">
		<li><a href="registration.html" class="link">Регистрация</a></li>
		<li><a href="authentication.jsp" class="link">Вход</a></li>
	</ul>
	</div>
</header>



<div class = "space center"></div>

<table class="dbTable">
	<tr>
		<th>Car Id</th>
		<th>Date</th>
		<th>Brand</th>
		<th>Mileage</th>
		<th>Equipment</th>
		<th>Seats</th>
		<th>Number Of Owners</th>
		<th>Gearbox</th>
		<th>Engine Volume</th>
		<th>VIN</th>
	</tr>

	<% List<Inspection> inspections = (List)request.getAttribute("inspections");
		if (inspections != null) {
			for (int i = 0; i < inspections.size(); i++)
			{
	%>
	<tr>
		<td align="center"><%=inspections.get(i).getId()%></td>
		<td align="center"><%=inspections.get(i).getDate()%></td>
		<td align="center"><%=inspections.get(i).getBrand()%></td>
		<td align="center"><%=inspections.get(i).getMileage()%></td>
		<td align="center"><%=inspections.get(i).getEquipment()%></td>
		<td align="center"><%=inspections.get(i).getSeats()%></td>
		<td align="center"><%=inspections.get(i).getNumberOfOwners()%></td>
		<td align="center"><%=inspections.get(i).getGearbox()%></td>
		<td align="center"><%=inspections.get(i).getEngineVolume()%></td>
		<td align="center"><%=inspections.get(i).getVin()%></td>
	</tr>
	<%}}%>

</table>

<footer>
<div id="foot">
©Mozgov
</div>
</footer>

</body>
</html>