<!--

Registrieren:

 Bestandteile Formular:

    + Einzeiliges Textfeld für Vorname
    + Einzeiliges Textfeld für Nachname
    + Mehrzeilige Textarea für Adresse
    + Drop-down Listbox für Herkunftsland (Österreich/Schweiz/Deutschland/andere)
    + Einzeiliges Textfeld für gewünschte User-ID
    + Passwortfeld für Passwort
    + Passwortfeld für Bestätigung des Passworts
    + Radiobutton für Geschlecht (weiblich/männlich)
    + Drop-down Listbox für Studiengang
    + Radiobutton für Studienjahr
    + Checkbox für verschiedene Berechtigungsstufen: Dozent, Student, Admin
    + Einzeiliges Textfeld für E-Mail

 Erstellen Sie Plausibilitätsprüfungen für das User-ID-Antragsformular, geschrieben
 in JavaScript. So soll geprüft werden, ob:

    + Jedes Feld ausgefüllt ist
    + In jeder Gruppe von Radio-Buttons bzw. Check-Boxes eine Auswahl getroffen wurde
    + Die User-ID gültig ist (muss zwischen 5 und 8 Zeichen lang sein und darf nur
      Buchstaben und “_“, keine Leer- oder Sonderzeichen und keine Ziffern enthalten)
    + Das Passwort gültig ist (muss zwischen 6 und 9 Zeichen lang sein und mit
      einem Buchstaben anfangen und darf nur Buchstaben, Ziffern und “_“, keine
      Leer- oder Sonderzeichen enthalten)
    + Passwort und dessen Bestätigung übereinstimmen
    + die E-Mail-Adresse syntaktisch korrekt aufgebaut ist:
      Der Namensteil einer gültigen E-Mail-Adresse soll nur mit einem Buchstaben
      beginnen dürfen. Danach darf eine beliebige Folge von Buchstaben, Zahlen,
      “_“ und “-“ auftreten. Ein “.“ darf immer nur einzeln (nicht gefolgt von anderen
      “.“) und nicht am Anfang oder Ende des Namensteils erscheinen. Nach dem
      Namensteil folgt ein “@“ und danach der Domain-Name, deren Aufbau den
      bekannten Kriterien genügen muss. Die Verwendung des HTML5 "email"-
      Attributs für das <input>-Element ist nicht zulässig.
    + Setzen Sie für die Prüfung der Felder, deren Inhalt einer bestimmten Syntax
      genügen muss, Regular Expressions ein.
    + Nur ein Formular, das die Plausibilitätsprüfungen bestanden hat, darf versandt werden.

 -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrieren</title>
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
            <li><a href="mailto:schiener5@hotmail.com?Subject=Hello%20there"><img src="Mail.jpg" alt="FHV_Logo"
                                                                                  width="50px"></a></li>
        </ul>
    </nav>

    <article>
        <h1>Registrieren</h1>
        <p>Für neue Registrierung bitte das Formular vollständig ausfüllen!</p>
        <br>

        <form id="Registrieren" name="Registrieren" class="Registrieren" action="mailto: schiener5@hotmail.com"
              method="post"
              enctype="text/plain">
            Username:<br>

            <input type="text" name="Username" id="Username" value="">
            (zwischen 5 und 8 Zeichen, nur Buchstaben und "_", keine Ziffern, Leer- oder Sonderzeichen.)

            <br>
            Passwort: &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; Passwort bestätigen:<br>
            <input type="password" id="p1" name="Passwort" value="">
            <input type="password" id="p2" name="Passwort2" value="">
            (zwischen 6 und 9 Zeichen, muss mit einem Buchstaben anfangen. Nur Buchstaben, Ziffern und "_", keine Leer-
            oder Sonderzeichen.)

            <br>

            Vorname: &emsp; &emsp; &emsp; &emsp;&emsp;&emsp; Nachname:<br>
            <input type="text" id="Vorname" name="Vorname" value="">
            <input type="text" id="Nachname" name="Nachname" value="">
            <br>
            Adresse:
            <br>
            <textarea name="Adresse" id="Adresse" rows="5" cols="20"></textarea>
            <br>
            Herkunftsland:
            <br>
            <select name="Herkunftsland" id="Herkunftsland">
                <option value="Österreich">Österreich</option>
                <option value="Schweiz">Schweiz</option>
                <option value="Deutschland">Deutschland</option>
                <option value="Andere">Andere</option>
            </select>
            <br>
            Geschlecht:
            <br>
            <input type="radio" name="Geschlecht" id="Weiblich" value="Weiblich"> Weiblich<br>
            <input type="radio" name="Geschlecht" id="Männlich" value="Männlich"> Männlich<br>
            Studiengang:
            <br>
            <select name="Studiengang" id="Studiengang">
                <option value="Informatik">Informatik</option>
                <option value="Mechatronik">Mechatronik</option>
                <option value="Elektrotechnik">Elektrotechnik</option>
                <option value="Betriebswirtschaftslehre">Betriebswirtschaftslehre</option>
                <option value="Sozialarbeit">Sozialarbeit</option>
                <option value="Intermedia">Intermedia</option>
            </select>
            <br>
            Semester:
            <br>
            <input type="radio" name="Semester" id="Sem1" value="1"> 1<br>
            <input type="radio" name="Semester" id="Sem2" value="2"> 2<br>
            <input type="radio" name="Semester" id="Sem3" value="3"> 3<br>
            <input type="radio" name="Semester" id="Sem4" value="4"> 4<br>
            <input type="radio" name="Semester" id="Sem5" value="5"> 5<br>
            <input type="radio" name="Semester" id="Sem6" value="6"> 6<br>
            Berechtigungsstufe:
            <br>
            <input type="checkbox" name="Berechtigung" id="Student" value="Student" checked> Student<br>
            <input type="checkbox" name="Berechtigung" id="Dozent" value="Dozent"> Dozent<br>
            <input type="checkbox" name="Berechtigung" id="Admin" value="Admin"> Admin<br>
            Email:<br>

            <input type="text" name="Email" id="Email" value="">
            <br><br>

            Bestätigen: &emsp; &emsp; Formular zurücksetzen: <br>


            <input type="submit" value="Bestätigen" onclick="return submitFunction()">
            <input type="button" onclick="resetFunction()" value="Zurücksetzen">
            <br>
        </form>

        <script>
            function submitFunction() {
                if (!checkFieldsFunction() || !checkUsernameLengthFunction() || !checkUsernameConstraintsFunction() || !comparePasswordFunction() || !checkPasswordLengthFunction()) {
                    return false;
                }
            }

            function resetFunction() {
                document.getElementById("Registrieren").reset();
            }

            function comparePasswordFunction() {
                var x = document.getElementById("p1")
                var y = document.getElementById("p2")

                if (x.value != y.value) {
                    alert("Passwords dont match!")
                    return false;
                } else {
                    return true;
                }
            }

            function checkFieldsFunction() {

                if(!checkTextsFunction(document.getElementById("Username"))){
                    return false;
                }
                if(!checkTextsFunction(document.getElementById("p1"))){
                    return false;
                }
                if(!checkTextsFunction(document.getElementById("p2"))){
                    return false;
                }
                if(!checkTextsFunction(document.getElementById("Vorname"))){
                    return false;
                }
                if(!checkTextsFunction(document.getElementById("Nachname"))){
                    return false;
                }
                if(!checkTextsFunction(document.getElementById("Adresse"))){
                    return false;
                }
                if(!checkTextsFunction(document.getElementById("Email"))){
                    return false;
                }

                if (!checkGenderFunction() || !checkSemesterFunction()) {
                    return false;
                }
                return true;
            }

            function checkGenderFunction() {
                if (!document.getElementById("Männlich").checked && !document.getElementById("Weiblich").checked) {
                    alert("Geschlecht fehlt")
                    document.getElementById("Männlich").focus();
                    return false;
                } else {
                    return true;
                }
            }

            function checkSemesterFunction() {
                if (!document.getElementById("Sem1").checked && !document.getElementById("Sem2").checked && !document.getElementById("Sem3").checked &&
                    !document.getElementById("Sem4").checked && !document.getElementById("Sem5").checked && !document.getElementById("Sem6").checked) {
                    alert("Semester fehlt")
                    document.getElementById("Sem1").focus();
                    return false;
                } else {
                    return true;

                }
            }

            function checkTextsFunction(x) {

                if (x.value == "") {
                    alert(x.name + " fehlt")
                    x.focus();
                    return false;
                } else {
                    return true;
                }
            }


            function checkUsernameLengthFunction() {

                var x = document.getElementById("Username").value

                if (x.length > 8 || x.length < 5) {
                    alert("Username Länge falsch")
                    document.getElementById("Username").focus();
                    return false;
                } else {
                    return true;
                }
            }

            function checkPasswordLengthFunction() {

                var x = document.getElementById("p1").value

                if (x.length > 9 || x.length < 6) {
                    alert("Passwort Länge falsch")
                    document.getElementById("p1").focus();
                    return false;
                } else {
                    return true;
                }
            }

            function checkUsernameConstraintsFunction() {

                var patt = /^[A-Za-z_]+$/;
                if (!patt.test(document.getElementById("Username").value)) {
                    alert("Username enthält ungültige Zeichen")
                    document.getElementById("Username").focus();
                    return false;
                } else {
                    return true;
                }
            }

            function checkEmailConstraintsFunction(){

                var patt = /^[A-Za-z]+[A-Za-z0-9_\-]*[.]?[A-Za-z0-9_\-]+[@][A-Za-z]+[A-Za-z0-9_\-]*[.][A-Za-z0-9_\-]+[.]?[A-Za-z0-9_\-]+$/;

                if (!patt.test(document.getElementById("Email").value)) {
                    alert("Email enthält ungültige Zeichen")
                    document.getElementById("Email").focus();
                    return false;
                } else {
                    return true;
                }
            }


        </script>

        <p>Wenn Sie auf "Bestätigen" klicken, wird die Registrierung abgeschickt!</p>


    </article>

    <footer>www.fhv.at
    </footer>

</div>


</body>
</html>