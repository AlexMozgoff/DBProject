<%@ page import="main.java.logic.Logic" %>
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

<div class="center label textCenter">Amount of agreements observed by a dealer</div>

<form action="agreementscount" method="get" class="center">

    <div class="regTextboxes">

        <div class="field">
            <label for "id" class="label">Dealer Id</label>
            <input class="input" name="dealerId"/>
        </div>

        <input class="mainPageButton" type="submit" value="Go"></input>

    </div>


</form>

<footer>
    <div id="foot">
        ©Mozgov
    </div>
</footer>

</body>
</html>
