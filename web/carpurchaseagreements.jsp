<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="main.java.database.entities.CarPurchaseAgreement" %>
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
		<th>Car ID</th>
		<th>Brand</th>
		<th>Date</th>
		<th>Commission</th>
		<th>Remark</th>
	</tr>

	<% List<CarPurchaseAgreement> carPurchaseAgreements = (List)request.getAttribute("carPurchaseAgreementsList");
	if (carPurchaseAgreements != null) {
	for (int i = 0; i < carPurchaseAgreements.size(); i++)
	{
	%>
	<tr>
		<td align="center"><%=carPurchaseAgreements.get(i).getCarId()%></td>
		<td align="center"><%=carPurchaseAgreements.get(i).getCarBrand()%></td>
		<td align="center"><%=carPurchaseAgreements.get(i).getDate()%></td>
		<td align="center"><%=carPurchaseAgreements.get(i).getCommission()%></td>
		<td align="center"><%=carPurchaseAgreements.get(i).getRemark()%></td>
		<td align="center"><a href="deletepurchaseagreement?carId=<%=carPurchaseAgreements.get(i).getCarId()%>"><img
				src="source/cross.svg" class="icon noBorders"></a></td>
		<td align="center"><a href="editpurchaseagreement?carId=<%=carPurchaseAgreements.get(i).getCarId()%>
														 &brand=<%=carPurchaseAgreements.get(i).getCarBrand()%>
														 &date=<%="'" + carPurchaseAgreements.get(i).getDate() + "'"%>
														 &commission=<%=carPurchaseAgreements.get(i).getCommission()%>
														 &remark=<%=carPurchaseAgreements.get(i).getRemark()%>">
			<img src="source/edit.svg" class="icon noBorders"></a></td>
	</tr>
	<%}}%>

</table>
</div>

<a href="addcarpurchaseagreement.jsp" class = "addCarPurchaseAgreement"><button class = "mainPageButton">Add</button></a>

<footer>
<div id="foot">
©Mozgov
</div>
</footer>

</body>
</html>