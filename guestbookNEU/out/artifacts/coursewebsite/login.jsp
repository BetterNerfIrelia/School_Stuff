<%--
  Created by IntelliJ IDEA.
  User: schie
  Date: 18.04.2018
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html lang="de">
<head>
    <meta charset="UTF-8">

    <title>LogIn</title>
    <link rel="stylesheet" href="style.css"/>
    <style>
        a:hover {
            color: blueviolet;
        }
    </style>
</head>
<body>

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
        <h1>Login</h1>

        <form id="Login" name="Login" action="/coursewebsite/ControlLogin.jsp" method="post">
            Username:<br>

            <input type="text" name="Username" id="Username" value="">
            <br>

            Passwort:<br>

            <input type="password" name="Passwort" id="Passwort" value="">
            <br>
            <br>

            <input type="submit" value="Login">


            <br>
            <br>
            <br>
            <br>
            <br>
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
</html>





