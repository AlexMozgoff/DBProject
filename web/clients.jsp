<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="main.java.database.entities.Client" %>
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

<div class="space center"></div>
<div class="center">
    <table class="dbTable">
        <tr>
            <th>Surname</th>
            <th>Name</th>
            <th>Patronymic</th>
            <th>City</th>
            <th>Address</th>
            <th>Phone</th>
        </tr>

        <% List<Client> clientsList = (List) request.getAttribute("clientsList");
            if (clientsList != null) {
                for (int i = 0; i < clientsList.size(); i++) {
        %>
        <tr>
            <td align="center"><%=clientsList.get(i).getSurname()%>
            </td>
            <td align="center"><%=clientsList.get(i).getName()%>
            </td>
            <td align="center"><%=clientsList.get(i).getPatronymic()%>
            </td>
            <td align="center"><%=clientsList.get(i).getCity()%>
            </td>
            <td align="center"><%=clientsList.get(i).getAddress()%>
            </td>
            <td align="center"><%=clientsList.get(i).getPhone()%>
            </td>
            <td align="center"><a
                    href="deleteclient?surname=<%=clientsList.get(i).getSurname()%>&name=<%=clientsList.get(i).getName()%>"><img
                    src="source/cross.svg" class="icon noBorders"></a></td>
            <td align="center"><a
                    href="editclient?surname=<%=clientsList.get(i).getSurname()%>&name=<%=clientsList.get(i).getName()%>&patronymic=<%=clientsList.get(i).getPatronymic()%>&city=<%=clientsList.get(i).getCity()%>&address=<%=clientsList.get(i).getAddress()%>&phone=<%=clientsList.get(i).getPhone()%>">
                <img src="source/edit.svg" class="icon noBorders"></a></td>
        </tr>
        <%
                }
            }
        %>

    </table>
</div>

<a href="addclient.jsp" class="addCarPurchaseAgreement">
    <button class="mainPageButton">Add</button>
</a>

<footer>
    <div id="foot">
        ©Mozgov
    </div>
</footer>


<header>
    <div class="logo"><a href="mainpage">CarTrade</a></div>
    <ul class="menu">
        <li><a href="exit" class="link">Выход</a></li>
    </ul>
    </div>
</header>

</body>
</html>