<%--
  Created by IntelliJ IDEA.
  User: schie
  Date: 27.03.2018
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Entry</title>
    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
<%
    Cookie adresse = new Cookie("adresse", request.getRequestURI());
    adresse.setMaxAge(60 * 60 * 24);
    response.addCookie(adresse);
%>
<h1>Gästebuch Eintrag</h1>

<form method="post" action="entryServlet">
    <label>Name</label><br>
    <input type="text" id="Name" name="Name" maxlength="30">
    <br><br>

    <label>Email</label><br>
    <input type="email" id="Email" name="Email" maxlength="30">
    <br><br>

    <label>Kommentar</label><br>
    <textarea rows="5" cols="50" name="Kommentar" maxlength="255"></textarea>
    <br><br>

    <input type="submit">
</form>
</body>
</html>

