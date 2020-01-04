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

<div class="center label textCenter">Add car purchase agreement</div>

<form action="addcarpurchaseagreement" method="get" class="center">

    <div class="regTextboxes fillBottom">
        <div class="field">
            <label for "brand" class="label">Brand</label>
            <input type="text" class="input" name="brand"/>
        </div>
        <div class="field">
            <label for "dateOfRelease" class="label">Date Of Release</label>
            <input type="text" class="input" name="dateOfRelease" pattern="[0-9]{4}"/>
        </div>

        <div class="field">
            <label for "mileage" class="label">Mileage</label>
            <input id="mileage" class="input" name="mileage" pattern="^[0-9]+$"/>
        </div>

        <div class="field">
            <label for "price" class="label">Price</label>
            <input id="price" class="input" name="price">
        </div>

        <div class="field">
            <label for "date" class="label">Date</label>
            <input id="date" class="input" name="date" pattern="[0-9]{4}.[0-9]{2}.[0-9]{2}" required
                   placeholder="2019.12.31">
        </div>

        <div class="field">
            <label for "commission" class="label">Commission</label>
            <input id="commission" class="input" name="commission">
        </div>

        <div class="field">
            <label for "remark" class="label">Remark</label>
            <input id="remark" class="input" name="remark">
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
