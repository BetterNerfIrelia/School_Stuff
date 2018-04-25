<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
Erweitern Sie Ihre Punktekonten-Web-Site um ein Session-Management. Dabei soll
für jeden Benutzer festgehalten werden, welche Seiten der Punktekonten-Web-Site
er seit seinem Login angesehen hat. Halten Sie die Titel (entsprechen den LinkTiteln
in der Navigationsleiste) der besuchten Seiten zusammen mit der Uhrzeit des
jeweiligen Seitenaufrufs in der Reihenfolge des Besuchs in einem Attribut des
entsprechenden impliziten Objekts fest und zeigen Sie die Titel mit der Uhrzeit
dem Benutzer an, wenn er den Link „Historie“, der noch in der Navigationsleiste
anzulegen ist, anklickt.
Integrieren Sie die vorzunehmenden Auswertungen und Operationen in die
bestehenden Java-Komponenten (Servlets, JSPs, JavaBeans) Ihrer MVCArchitektur.
Setzen Sie in Ihren JSPs die JSTL Core Tags ein, wo sinnvoll.
Verwenden Sie in den JSPs nur Tags, keine Scriptlets und keinen Java-Code.
Greifen Sie aus den JSPs heraus nur lesend auf JavaBeans zu und rufen Sie keine
Methoden auf. Alle eingehenden Requests sollten vom Controller-Servlet
entgegengenommen und verarbeitet werden. Jeder Response an den Benutzer soll
aus einer eigenständigen JSP heraus erzeugt werden.
Dokumentieren Sie, welchen Web-Container Sie einsetzen und das Deployment
ihrer Web-Applikation darauf.
Neben dem Source-Code und der Dokumentation reichen Sie bitte ein deploybares
WAR-File zusammen mit Ihrer Lösung ein.
Die Aufgabe wird in den folgenden Übungsblättern fortgesetzt




History speichert Zeiten, dann jstl für tabelle.





--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabellen</title>
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
        <h1>Historie</h1>

        <table border="1">
            <tr>
            <th>Time</th>
            <th>Site</th>
            </tr>
            <c:forEach items="${sessionScope.HistoryBean.visits}" var="element">
                <tr>
                    <td>${element.time}</td>
                    <td>${element.site}</td>
                </tr>
            </c:forEach>
        </table>




    </article>
    <footer>www.fhv.at
    </footer>


</div>
</body>
</html>