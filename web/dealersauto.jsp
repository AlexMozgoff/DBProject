<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="main.java.database.entities.Auto" %>
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
		<th>Id</th>
		<th>Brand</th>
		<th>Photo</th>
		<th>Date Of Release</th>
		<th>Mileage</th>
		<th>Price</th>
		<th>Is sold</th>
	</tr>

	<% List<Auto> dealersList = (List)request.getAttribute("autoList");
	if (dealersList != null) {
		for (int i = 0; i < dealersList.size(); i++)
		{
	%>
	<tr>
		<td align="center"><%=dealersList.get(i).getId()%></td>
		<td align="center"><%=dealersList.get(i).getBrand()%></td>
		<td align="center"><%=dealersList.get(i).getPhoto()%></td>
		<td align="center"><%=dealersList.get(i).getDateOfRelease()%></td>
		<td align="center"><%=dealersList.get(i).getMileage()%></td>
		<td align="center"><%=dealersList.get(i).getPrice()%></td>
		<td align="center"><%=dealersList.get(i).isSold()%></td>
		<td align="center"><a href="deleteauto?id=<%=dealersList.get(i).getId()%>"><img
				src="source/cross.svg" class="icon noBorders"></a></td>
	</tr>
	<%}}%>

</table>
</div>

<footer>
<div id="foot">
©Mozgov
</div>
</footer>

</body>
</html>