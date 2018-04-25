<%@ page import="at.fhv.ssc.hibernate.DatabaseFacade" %>
<%@ page import="at.fhv.ssc.pojo.Guestentry" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: schie
  Date: 27.03.2018
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="de">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Gästebuch</title>
  <link rel="stylesheet" href="style.css"/>
    <style>
        a:hover {
            color: blueviolet;
        }
    </style>
</head>
<body>
<%
    Cookie adresse = new Cookie("adresse", request.getRequestURI());
    adresse.setMaxAge(60 * 60 * 24);
    response.addCookie(adresse);
%>
<div class="container">

  <header>
    <img src="FHV_Logo.jpg" alt="FHV_Logo" width="500">
  </header>

    <nav>
        <ul>
            <li><a href=index>Home</a></li>
            <br>
            <li><a href=webapplikationen>Webapplikationen</a></li>
            <br>
            <li><a href=softwareentwicklung>Nutzerzentrierte Softwareentwicklung</a></li>
            <br>
            <li><a href=softwaresicherheit>Software und IT-Sicherheit</a></li>
            <br>
            <li><a href=bilder>Bilder</a></li>
            <br>
            <li><a href=registrieren>Registrieren</a></li>
            <br>
            <li><a href="guestbook">Gästebuch</a></li>
            <br>
            <li><a href="tabellen">Tabellen</a></li>
            <br>
            <li><a href="login">Login</a></li>
            <br>
            <li><a href="historie">Historie</a></li>
            <br>
            <li><a href="mailto:schiener5@hotmail.com?Subject=Hello%20there"><img src="Mail.jpg" alt="FHV_Logo" width="50px"></a></li>
            <br>
        </ul>
    </nav>


    <article>
    <h1>Gästebuch</h1>

    <a href = "/coursewebsite/neuerEintrag">
      <button>Neuer Eintrag</button>
    </a>
    <br>
    <br>
      <table>
          <th>Name</th>
          <th>Email</th>
          <th>Kommentar</th>
          <%
              DatabaseFacade facade = new DatabaseFacade();
              List<Guestentry> entries = facade.loadAllGuestentry();
              for (Guestentry e : entries) {
          %>
          <tr>
              <td>
                  <%= e.getName()%>
              </td>
              <td>
                  <%= e.getEmail()%>
              </td>
              <td>
                  <%= e.getComment()%>
              </td>
          </tr>
          <%
              }
          %>
      </table>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>

  </article>
    <footer>www.fhv.at
    </footer>
</div>
  </body>