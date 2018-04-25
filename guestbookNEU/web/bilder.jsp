<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bilder</title>
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
        <h1>Bilder</h1>
        <a style="cursor: pointer" onclick="popUpWindow('Haus.jpg')"><img id="Haus" src="Haus.jpg" alt="Gebäude FHV" height="300"></a>

        <a style="cursor: pointer" onclick="popUpWindow('Haus2.jpg')"><img id="Haus2" src="Haus2.jpg" alt="Gebäude FHV" height="300"></a>

        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>

        <script>
        function popUpWindow(url) {
            var x = new Image();
            x.src = url;

                var width = x.naturalWidth;
                var height = x.naturalHeight;

                var popup = window.open("", "", "width=" + width + ",height=" + height);
                popup.document.write(
                        "<html>\n" +
                        "<head>\n" +
                        "    <title>Bilder</title>\n" +
                        "</head>\n" +
                        "<body style='margin:0;border:0;'>\n" +
                        "<img src=" + url + ">\n" +
                        "<button type='button' style='top: 5px; right: 5px; position: absolute;' onclick='window.close()'>&times;</button>" +
                        "</body>\n" +
                        "</html>"
                )
        }
         

        </script>




    </article>

    <footer>www.fhv.at
    </footer>

</div>

</body>
</html>

















