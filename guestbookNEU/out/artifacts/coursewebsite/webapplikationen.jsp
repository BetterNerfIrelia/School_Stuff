<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Webapplikationen</title>
    <link rel="stylesheet" href="style.css" />
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
            <li><a href=index>Home</a></li><br>
            <li><a href=webapplikationen>Webapplikationen</a></li><br>
            <li><a href=softwareentwicklung>Nutzerzentrierte Softwareentwicklung</a></li><br>
            <li><a href=softwaresicherheit>Software und IT-Sicherheit</a></li><br>
            <li><a href=bilder>Bilder</a></li>
            <br>
            <li><a href=registrieren>Registrieren</a></li>
            <br>
            <li><a href="guestbook">Gästebuch</a></li>
            <br>
            <li><a href="tabellen">Tabellen</a></li>
            <br>
            <li><a href="mailto:schiener5@hotmail.com?Subject=Hello%20there"><img src="Mail.jpg" alt="FHV_Logo" width="50"></a></li>
            </p>
        </ul>
    </nav>

    <article>
        <h1>Webapplikationen</h1>
        <h4>Sommersemester 2018</h4>
        <h4>Dozent: Thomas Feilhauer</h4>
        <p><i>Die LV beschäftigt sich mit der Planung, dem Entwurf und dem Aufbau komplexer Web-Applikationen.
            Insbesondere werden Technologien zur Erstellung dynamischer Web-Applikationen detailliert betrachtet;</i></p>
        <table>
            <tr>
                <th>Student</th>
                <th>Übung 1</th>
                <th>Übung 2</th>
                <th>Klausur</th>
                <th>Endnote</th>
            </tr>
            <tr>
                <td>Anne Jovanovics</td>
                <td>1.0</td>
                <td>1.0</td>
                <td>1.0</td>
                <td>1.0</td>
            </tr>
            <tr>
                <td>Thomas Kasseroller</td>
                <td>2.5</td>
                <td>2.1</td>
                <td>1.2</td>
                <td>2.0</td>
            </tr>
            <tr>
                <td>Johannes Koch</td>
                <td>1.1</td>
                <td>1.7</td>
                <td>1.1</td>
                <td>1.9</td>
            </tr>
            <tr>
                <td>Sebastian Schiener</td>
                <td>2.0</td>
                <td>2.2</td>
                <td>3.0</td>
                <td>2.4</td>
            </tr>
        </table>
    </article>


    <footer>www.fhv.at
    </footer>

</div>

</body>
</html>

















