<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css" type="text/css">
    <link rel="shortcut icon" href="favicon.png" type="image/png">
    <meta charset="utf-8">
    <title>Title</title>
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

<div class="space center"></div>

<div class="center label textCenter">Add client</div>

<form action="addclient" method="get" class="center">

    <div class="regTextboxes">

        <div class="field">
            <label for "name" class="label">Name</label>
            <input class="input" name="name"/>
        </div>

        <div class="field">
            <label for "surname" class="label">Surname</label>
            <input class="input" name="surname"/>
        </div>

        <div class="field">
            <label for "patronymic" class="label">Patronymic</label>
            <input class="input" name="patronymic"/>
        </div>

        <div class="field">
            <label for "city" class="label">City</label>
            <input class="input" name="city">
        </div>

        <div class="field">
            <label for "address" class="label">Address</label>
            <input class="input" name="address">
        </div>

        <div class="field">
            <label for "phone" class="label">Phone</label>
            <input class="input" name="phone" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
                   required placeholder = "927-123-4567">
        </div>

        <input class="mainPageButton" type="submit" value="Add"></input>
    </div>

</form>

<footer>
    <div id="foot">
        ©Mozgov
    </div>
</footer>

</body>
</html>
