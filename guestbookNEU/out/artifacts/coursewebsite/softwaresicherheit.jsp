<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Softwaresicherheit</title>
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
        <h1>Software und IT-Sicherheit</h1>
        <h4>Sommersemester 2018</h4>
        <h4>Dozent: Armin Simma</h4>
        <p><i>Die Studierenden kennen und verstehen Modelle, Konzepte und Werkzeuge,
            um Sicherheit in allen Phasen des Entwicklungsprozesses
            (inkl. Anforderungsanalyse,  Entwurf und der Implementierung) von Software einzubauen
            den Betrieb und das Management von (Software-/IT-)Systemen sicher zu machen.
            Studierende kennen und verstehen Ansätze, Prozesse, Methoden und Technologien zum Risikomanagement.
            Sie können die OWASP risk rating-Methode anwenden.</i></p>

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
                <td>2.0</td>
                <td>2.2</td>
                <td>1.2</td>
                <td>2.2</td>
            </tr>
            <tr>
                <td>Johannes Koch</td>
                <td>1.5</td>
                <td>1.3</td>
                <td>2.0</td>
                <td>1.5</td>
            </tr>
            <tr>
                <td>Sebastian Schiener</td>
                <td>1.0</td>
                <td>1.2</td>
                <td>3.0</td>
                <td>2.0</td>
            </tr>


        </table>
    </article>

    <footer>www.fhv.at
    </footer>

</div>

</body>
</html>

















