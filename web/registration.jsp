<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css">
<link rel="shortcut icon" href="favicon.png" type="image/png">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Регистрация</title>
</head>
<body class = "regBody">

<hr noshade id="line1">
<hr noshade id="line2">

<form action = "registration" method="post" class="center regSpace">
	<div class="regTextboxes">
		<div class = "registrationField">
			<label for "surname" class="label">Surname </label>
			<input id = "surname" class="input" name = "surname">
		</div>
		<div class = "registrationField">
			<label for "name" class="label">Name </label>
			<input id = "name" class="input" name = "name">
		</div>
		<div class = "registrationField">
			<label for "patronymic" class="label">Patronymic </label>
			<input id = "patronymic" class="input" name = "patronymic">
		</div>
		<div class = "registrationField">
			<label for "address" class="label">Address </label>
			<input id = "address" class="input" name = "address">
		</div>
		<div class = "registrationField">
			<label for "phone" class="label">Phone </label>
			<input id = "phone" class="input" type = "tel" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
       required placeholder = "927-123-4567" name = "phone">
		</div>
		<div class = "registrationField">
			<label for "login" class="label">Login </label>
			<input id = "login" class="input" name = "login">
		</div>
		<div class = "registrationField">
			<label for "pass" class="label">Password </label>
			<input id = "pass" type = "password" class="input" name = "password">
		</div>
		<div class = "registrationField">
			<label for "repeatPassword" class="label">Repeat password </label>
			<input id = "repeatPassword" type = "password" class = "input" name = "repeatPassword">
		</div>
		<input type = "submit" id = "regenter" value="Register"></input>
	</div>
</form>

<header>
<div class="logo"><a href="mainpage">CarTrade</a></div>
	<ul class="menu">
		<li><a href="registration.jsp" class="link">Регистрация</a></li>
		<li><a href="authentication.html" class="link">Вход</a></li>
	</ul>
</header>

<footer>
<div id="foot">
©Mozgov
</div>
</footer>

</body>
</html>