<html>

<head>
<link rel="stylesheet" href="style.css" type="text/css">
<link rel="shortcut icon" href="favicon.png" type="image/png">
<meta charset="utf-8">
<title>Вход</title>
</head>

<body>

<hr noshade id="line1">
<hr noshade id="line2">

<header>
<div class="logo"><a href="mainpage">CarTrade</a></div>
	<ul class="menu">
		<li><a href="registration.jsp" class="link">Регистрация</a></li>
		<li><a href="authentication.jsp" class="link">Вход</a></li>
	</ul>
</header>

<form action = "authentication" class="center authSpace">
	<div class = "regTextboxes">
		<div class = "registrationField">
			<label for "login" class="label">Логин </label>
			<input type="text" id="login" class="input" name="login">
		</div>
		<div class = "registrationField">
			<label for "password" class="label">Пароль </label>
			<input type="password" id="password" class="input" name="password">
		</div>
		<input type="submit" value="Вход" id="enter">
	</div>
</form>


<footer>
<div id="foot">
©Mozgov
</div>
</footer>

</body>
</html>