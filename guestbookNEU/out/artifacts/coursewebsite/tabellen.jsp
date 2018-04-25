<%--
Schreiben Sie eine JSP, die dynamisch Tabellen generiert. Sehen Sie dabei zwei
Input-Felder vor, über die die Anzahl der Spalten und Zeilen (jeweils ≤ 16) der
Tabelle eingegeben werden können. Wenn der Anwender das Formular abschickt,
verarbeitet die JSP die Anfrage und generiert die Tabelle. In jedem Feld sollen
dynamisch die Koordinaten des Feldes (Spalte, Zeile) eingetragen werden. Ferner
soll die Hintergrundfarbe der Zelle abhängig von den Zellen-Koordinaten generiert
werden.
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
        <h1>Tabellen</h1>

         <form method=post action=tabellen.jsp>
         Tabelle Breite = <input type=number name=WIDTH  min="0" max="16" size=2>
         Tabelle Höhe = <input type=number name=HEIGHT min="0" max="16" size=2>
         <input type=submit value="Generiere Tabelle!">
         </form>
         <hr>
         <%  String w = request.getParameter("WIDTH");
             String h = request.getParameter("HEIGHT");
             if(w == null) w = "5";
             if(h == null) h = "5";
             int width  = Integer.parseInt(w)-1;
            int height = Integer.parseInt(h)-1;
             if(width>16)  width  = 16;
             if(width<0)   width  = 0;
             if(height>16) height = 16;
           if(height<0)  height = 0;
             String[] colorArray  = { "00", "11", "22", "33",
                    "44", "55", "66", "77",
                  "88", "99", "AA", "BB",
                "CC", "DD", "EE", "FF"  };  %>
         <table border=""0 cellpadding=0 cellspacing=0>
         <%  for(int y=0; y<=height; y++){    %>
                 <tr>
         <%      for(int x=0; x<=width; x++){
                  String bgColor = "AA" + colorArray[y] + colorArray[x];    %>
                   <td BGCOLOR=<%=bgColor%>>
                    <%=x%>, <%=y%>
                    </td>
         <%      }                    %>
                 </tr>
         <%  }             %>
         </table>
         </hr>




    </article>
    <footer>www.fhv.at
    </footer>


</div>
</body>
</html>
