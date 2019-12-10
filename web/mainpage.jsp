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

<div class="tabs center">
    <input type="radio" name="inset" value="" id="tab_1" checked>
    <label for="tab_1">Individual</label>

    <input type="radio" name="inset" value="" id="tab_2">
    <label for="tab_2">Cars</label>

    <input type="radio" name="inset" value="" id="tab_3">
    <label for="tab_3">Agreements</label>


    <div id="txt_1">
		<table id = "mainPageTable">
			<td>
				<a href = "dealers"><button class = "mainPageButton">Dealers</button></a>
			</td>
			<td>
				<a href = "clients"><button class = "mainPageButton">Clients</button></a>
			</td>
		</table>
    </div>
    <div id="txt_2">
		<table id = "mainPageTable">
			<td>
				<a href = "dealersAuto"><button class = "mainPageButton">Dealer's Auto</button></a>
			</td>
			<td>
				<a href = "inspection"><button class = "mainPageButton">Inspection</button></a>
			</td>
			<td>
				<a href = "testdrive"><button class = "mainPageButton">Test-drive</button></a>
			</td>
		</table>
    </div>
    <div id="txt_3">
		<table id = "mainPageTable">
			<td>
				<a href = "carpurchaseagreements"><button class = "mainPageButton">Car Purchase Agreements</button></a>
			</td>
			<td>
				<a href = "carsellagreements.html"><button class = "mainPageButton">Car Sell Agreements</button></a>
			</td>
		</table>
    </div>
</div>

<footer>
<div id="foot">
©Mozgov
</div>
</footer>

</body>
</html>