<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="main.java.database.entities.Dealer" %>
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
		<th>Surname</th>
		<th>Name</th>
		<th>Patronymic</th>
		<th>Photo</th>
		<th>Address</th>
		<th>Phone</th>
		<th>Login</th>
	</tr>

	<% List<Dealer> dealersList = (List)request.getAttribute("dealersList");
	if (dealersList != null) {
		for (int i = 0; i < dealersList.size(); i++)
		{
	%>
	<tr>
		<td align="center"><%=dealersList.get(i).getSurname()%></td>
		<td align="center"><%=dealersList.get(i).getName()%></td>
		<td align="center"><%=dealersList.get(i).getPatronymic()%></td>
		<td align="center"><%=dealersList.get(i).getPhoto()%></td>
		<td align="center"><%=dealersList.get(i).getAddress()%></td>
		<td align="center"><%=dealersList.get(i).getPhone()%></td>
		<td align="center"><%=dealersList.get(i).getLogin()%></td>
		<td align="center"><a href="deletedealer?login=<%=dealersList.get(i).getLogin()%>"><img
				src="source/cross.svg" class="icon noBorders"></a></td>
		<td align="center"><a href="editdealer?surname=<%=dealersList.get(i).getSurname()%>&name=<%=dealersList.get(i).getName()%>&patronymic=<%=dealersList.get(i).getPatronymic()%>&address=<%=dealersList.get(i).getAddress()%>&phone=<%=dealersList.get(i).getPhone()%>"><img
				src="source/edit.svg" class="icon noBorders"></a></td>
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