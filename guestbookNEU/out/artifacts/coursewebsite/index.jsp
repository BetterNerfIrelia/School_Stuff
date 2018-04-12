<!--

Allgemein: Website zur Ausgabe von Punktekonten für Studenten an der FHV
           index.jsp: Übersichtsseite, Auswahl der Kurse
           Kurstitel als Listenelemente, Links auf die jeweilige Seite

Einzelne Kursseiten: Studiengang, Titel des Kurses, Semester, Dozent
                     Danach Taballe mit allen Studenten und Punkten zu jeder
                     Übungsaufgabe und Klausur, Punktsummme, Endnote, MIND 2

Aufbau: Navigationsleiste, Logo der FHV,
        Überschriften, Unterüberschriften, Absätze, Hervorhebungen

Links für: Indexseite, Unterseiten, Email an mich schicken (plus Icon)

Neues Popup im Browser öffnen dort per JS Bild laden, Maße des Fensters sollen sich an Bild anpassen.
Plus Button zum Schließen.
ACHTUNG: Auf die Maße des Bildes kann man erst zugreifen, nachdem es geladen ist.


Ändern Sie Ihre Punktekonten-Web-Site so ab, dass bei Aufruf der Default-Seite
(index.jsp) automatisch auf die von diesem Browser aus zuletzt besuchte Seite der
Punktekonten-Web-Site umgeleitet wird (z.B. auf eine der Kursseiten). Legen Sie
dazu die Information über die zuletzt besuchte Seite in Cookies ab. Verwenden Sie
ein Servlet als Controller, das die Cookies einliest und die Umleitung auf die zuletzt
besuchte Seite vornimmt. Welche Änderungen müssen Sie an den bisherigen
HTML-Seiten vornehmen? Warum kann es zu Problemen aufgrund von Caching
kommen? Wie können Sie diese vermeiden?
Dokumentieren Sie, welchen Web-Container Sie einsetzen und das Deployment
ihrer Web-Applikation darauf.
Neben dem Source-Code und der Dokumentation reichen Sie bitte ein deploybares
WAR-File zusammen mit Ihrer Lösung ein.
Die Aufgabe wird in den folgenden Übungsblättern fortgesetzt.





 -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="FHV Fachhochschule Vorarlberg Studentenpunktekonto">
    <meta name="keywords" content="FHV, Fachhochschule, Vorarlberg, Dornbirn, Österreich, Punktekonto, Punkte, Student, Studenten, Webapplikationen, Softwareentwicklung, Softwaresicherheit">
    <meta name="author" content="Sebastian Schiener">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="refresh" content="0;URL=/coursewebsite/cookieServlet">

    <title>FHV-Courses</title>
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
            <li><a href="mailto:schiener5@hotmail.com?Subject=Hello%20there"><img src="Mail.jpg" alt="FHV_Logo" width="50px"></a></li>
            <br>
        </ul>
    </nav>

    <article>
        <h1>Übersicht</h1>
        <p>Willkommen!</p>
        <p>Bitte wählen sie einen Kurs aus.</p>
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

















