<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="main.java.database.objects.Client" %>
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
			<th>Surname</th>
			<th>Name</th>
			<th>Patronymic</th>
			<th>City</th>
			<th>Address</th>
			<th>Phone</th>
		</tr>

		<% List<Client> clientsList = (List)request.getAttribute("clientsList");
		if (clientsList != null) {
			for (int i = 0; i < clientsList.size(); i++)
			{
		%>
		<tr>
			<td align="center"><%=clientsList.get(i).getSurname()%></td>
			<td align="center"><%=clientsList.get(i).getName()%></td>
			<td align="center"><%=clientsList.get(i).getPatronymic()%></td>
			<td align="center"><%=clientsList.get(i).getCity()%></td>
			<td align="center"><%=clientsList.get(i).getAddress()%></td>
			<td align="center"><%=clientsList.get(i).getPhone()%></td>
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