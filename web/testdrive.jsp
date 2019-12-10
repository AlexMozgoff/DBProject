<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="main.java.database.objects.TestDrive" %>
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
		<th>Brand</th>
		<th>Client Name</th>
		<th>Client Surname</th>
		<th>Date</th>
	</tr>

	<% List<TestDrive> testDriveList = (List)request.getAttribute("testDriveList");
		if (testDriveList != null) {
			for (int i = 0; i < testDriveList.size(); i++)
			{
	%>
	<tr>
		<td align="center"><%=testDriveList.get(i).getCarId()%></td>
		<td align="center"><%=testDriveList.get(i).getCarBrand()%></td>
		<td align="center"><%=testDriveList.get(i).getClientName()%></td>
		<td align="center"><%=testDriveList.get(i).getClientSurname()%></td>
		<td align="center"><%=testDriveList.get(i).getDate()%></td>
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