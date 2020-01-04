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
				<a href = "dealers"><button class = "tableButton">Dealers</button></a>
			</td>
			<td>
				<a href = "clients"><button class = "tableButton">Clients</button></a>
			</td>
		</table>
    </div>
    <div id="txt_2">
		<table id = "mainPageTable">
			<td>
				<a href = "dealersAuto"><button class = "tableButton">Dealer's Auto</button></a>
			</td>
			<td>
				<a href = "inspection"><button class = "tableButton">Inspection</button></a>
			</td>
			<td>
				<a href = "testdrive"><button class = "tableButton">Test-drive</button></a>
			</td>
		</table>
    </div>
    <div id="txt_3">
		<table id = "mainPageTable">
			<td>
				<a href = "carpurchaseagreements"><button class = "tableButton">Car Purchase Agreements</button></a>
			</td>
			<td>
				<a href = "carsellagreements"><button class = "tableButton">Car Sell Agreements</button></a>
			</td>
		</table>
    </div>

	<a href = "agreementscount.jsp" class="logic"><button class = "tableButton">Amount of agreements observed by a dealer</button></a>
</div>

<footer>
<div id="foot">
©Mozgov
</div>
</footer>

</body>
</html>