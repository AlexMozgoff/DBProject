<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="main.java.database.entities.CarSellAgreement" %>
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

<div class = "space center"></div>
<div class="center">
<table class="dbTable">
	<tr>
		<th>Client ID</th>
		<th>Car ID</th>
		<th>Date</th>
		<th>Commission</th>
		<th>Remark</th>
	</tr>

	<% List<CarSellAgreement> carSellAgreements = (List)request.getAttribute("carSellAgreementList");
		if (carSellAgreements != null) {
			for (int i = 0; i < carSellAgreements.size(); i++)
			{
	%>
	<tr>
		<td align="center"><%=carSellAgreements.get(i).getClientId()%></td>
		<td align="center"><%=carSellAgreements.get(i).getCarId()%></td>
		<td align="center"><%=carSellAgreements.get(i).getDate()%></td>
		<td align="center"><%=carSellAgreements.get(i).getCommission()%></td>
		<td align="center"><%=carSellAgreements.get(i).getRemark()%></td>
		<td align="center"><a href="deletesellagreement?carId=<%=carSellAgreements.get(i).getCarId()%>"><img
				src="source/cross.svg" class="icon noBorders"></a></td>
		<td align="center"><a href="editsellagreement?clientId=<%=carSellAgreements.get(i).getClientId()%>
													 &carId=<%=carSellAgreements.get(i).getCarId()%>
													 &date=<%="'" + carSellAgreements.get(i).getDate() + "'"%>
													 &commission=<%=carSellAgreements.get(i).getCommission()%>
													 &remark=<%=carSellAgreements.get(i).getRemark()%>"><img
				src="source/edit.svg" class="icon noBorders"></a></td>
	</tr>
	<%}}%>

</table>
</div>

<a href="addsellagreement" class = "addCarPurchaseAgreement"><button class = "mainPageButton">Add</button></a>

<footer>
<div id="foot">
©Mozgov
</div>
</footer>

</body>
</html>