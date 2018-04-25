package at.fhv.ssc.servlets;

import at.fhv.ssc.mojo.HistoryBean;
import at.fhv.ssc.mojo.LoginBean;
import at.fhv.ssc.mojo.UserBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Erzeugung Tabelle:
 * create table userEntry(
 * userid varchar(8) primary key,
 * fname varchar(50),
 * lname varchar(50),
 * password varchar(9),
 * level varchar(50)
 * );
 * <p>
 * Pojo erstellen
 * Base-DAO anpassen in config-settings
 * dao machen
 * bean/controller machen
 * <p>
 * bean erstellt pojo und speichert in db, bzw. prüft bean ob es user schon gibt.
 * gibt dann dem controller nachricht ob erfolgreich oder nicht (=user schon in db)
 * <p>
 * <p>
 * <p>
 * Erweitern Sie Ihre Punktekonten-Web-Site um eine Benutzerauthentisierung.
 * Die Einträge des Benutzer-Antrag-Formulars sollen nun nicht mehr per E-Mail an
 * Sie geschickt werden, sondern automatisch in eine Datenbank eingetragen werden.
 * Dabei muss überprüft werden, ob es einen Benutzer mit der angegebenen User-ID
 * bereits gibt. Gibt es die User-ID noch nicht, wird ein neuer Datensatz in der Tabelle
 * angelegt (es genügt Vorname, Nachname, UserID, Passwort und
 * Berechtigungsstufe in die Datenbank einzutragen), ansonsten erfolgt eine
 * Rückmeldung an den Benutzer, dass eine andere User-ID gewählt werden muss.
 * Kann die neue User-ID angelegt werden, soll dem Benutzer zur Bestätigung eine
 * kurze Begrüßungsseite mit seiner User-ID angezeigt werden.
 * Durch die Benutzerauthentisierung soll der Benutzer erst nach erfolgter
 * Authentisierung Zugriff haben auf die Kursseiten. Überprüfen Sie dazu die vom
 * Benutzer eingegebenen User-ID und Passwort mit denen in der Datenbank. Der
 * Login soll nur einmal zu Beginn der Session erforderlich sein, danach kann jederzeit
 * ohne erneuten Login auf sämtliche Kursseiten zugegriffen werden.
 * Implementieren Sie die vorzunehmenden Auswertungen und Datenbankoperationen
 * in Java (Servlets, JSPs, JavaBeans) auf Basis einer geeigneten MVC-Architektur.
 * Setzen Sie in Ihren JSPs die JSTL Core Tags ein, wo sinnvoll.
 * Verwenden Sie in den JSPs nur Tags, keine Scriptlets und keinen Java-Code.
 * Greifen Sie aus den JSPs heraus nur lesend auf JavaBeans zu und rufen Sie keine
 * Methoden auf. Alle eingehenden Requests sollten vom Controller-Servlet
 * entgegengenommen und verarbeitet werden. Jeder Response an den Benutzer soll
 * aus einer entsprechenden JSP heraus erzeugt werden.
 * <p>
 * Dokumentieren Sie, welchen Web-Container Sie einsetzen und das Deployment
 * ihrer Web-Applikation darauf. Als DBMS stehen Ihnen MySQL auf Ihrem HomeShare
 * unter users2.fh-vorarlberg.ac.at zur Verfügung (Zugriff von außerhalb der
 * FHV über VPN!) oder die ORACLE-Datenbank auf dem ORACLE-Server der FHV.
 * Wenn Sie sich für den Einsatz einer ORACLE-Datenbank auf dem ORACLE-Server
 * der FHV entscheiden sollten, beachten Sie bitte, dass zum Zugriff auf die
 * Datenbank die Installation der JDBC-Treiber (classes12.jar) im CLASSPATH
 * erforderlich ist.
 * Neben dem Source-Code und der Dokumentation reichen Sie bitte ein deploybares
 * WAR-File zusammen mit Ihrer Lösung ein.
 * Die Aufgabe wird in den folgenden Übungsblättern fortgesetzt.
 **/

public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        redirect(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        redirect(req, resp);
    }

    private void historyblub(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HistoryBean history = (HistoryBean) req.getSession().getAttribute("HistoryBean");
        history.addVisit(req.getRequestURI());
    }

    private void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String requestURI = req.getRequestURI();

        if (requestURI.equals("/coursewebsite/ControlRegistrieren.jsp")) {
            String userid = req.getParameter("Username");
            String fname = req.getParameter("Vorname");
            String lname = req.getParameter("Nachname");
            String passwort = req.getParameter("Passwort");
            String level = req.getParameter("Berechtigung");

            UserBean bean = new UserBean(userid, fname, lname, passwort, level);

            req.getSession().setAttribute("UserBean", bean);

            bean.saveUser();

            if (bean.isSuccess()) {
                resp.sendRedirect("/coursewebsite/registrierenWelcome");
            } else {
                resp.sendRedirect("/coursewebsite/registrierenError");
            }
        } else if (requestURI.equals("/coursewebsite/ControlLogin.jsp")) {
            String userid = req.getParameter("Username");
            String passwort = req.getParameter("Passwort");

            LoginBean bean = new LoginBean();

            req.getSession().setAttribute("LoginBean", bean);

            bean.checkLogIn(userid, passwort);

            if (bean.isSuccess()) {
                HistoryBean hist = new HistoryBean();
                req.getSession().setAttribute("HistoryBean", hist);
                req.getSession().setAttribute("loggedIN", true);
                resp.sendRedirect("/coursewebsite/loginSuccess");
            } else {
                req.getSession().removeAttribute("loggedIN");
                req.getSession().removeAttribute("HistoryBean");

                resp.sendRedirect("/coursewebsite/loginError");
            }
        } else if (requestURI.equals("/coursewebsite/softwareentwicklung")) {
            if (req.getSession().getAttribute("loggedIN") != null) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/softwareentwicklung_cw");
                historyblub(req, resp);
                dispatcher.forward(req, resp);


            } else {
                resp.sendRedirect("/coursewebsite/login");
            }
        } else if (requestURI.equals("/coursewebsite/softwaresicherheit")) {
            if (req.getSession().getAttribute("loggedIN") != null) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/softwaresicherheit_cw");
                historyblub(req, resp);
                dispatcher.forward(req, resp);

            } else {
                resp.sendRedirect("/coursewebsite/login");
            }
        } else if (requestURI.equals("/coursewebsite/webapplikationen")) {
            if (req.getSession().getAttribute("loggedIN") != null) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/webapplikationen_cw");
                historyblub(req, resp);
                dispatcher.forward(req, resp);

            } else {
                resp.sendRedirect("/coursewebsite/login");
            }
        } else if (requestURI.equals("/coursewebsite/bilder")) {
            if (req.getSession().getAttribute("loggedIN") != null) {
                historyblub(req, resp);
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/bilder_cw");
            dispatcher.forward(req, resp);
        } else if (requestURI.equals("/coursewebsite/index")) {
            if (req.getSession().getAttribute("loggedIN") != null) {
                historyblub(req, resp);
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/index_cw");
            dispatcher.forward(req, resp);
        } else if (requestURI.equals("/coursewebsite/registrieren")) {
            if (req.getSession().getAttribute("loggedIN") != null) {
                historyblub(req, resp);
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/registrieren_cw");
            dispatcher.forward(req, resp);
        } else if (requestURI.equals("/coursewebsite/guestbook")) {
            if (req.getSession().getAttribute("loggedIN") != null) {
                historyblub(req, resp);
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/guestbook_cw");
            dispatcher.forward(req, resp);
        } else if (requestURI.equals("/coursewebsite/tabellen")) {
            if (req.getSession().getAttribute("loggedIN") != null) {
                historyblub(req, resp);
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/tabellen_cw");
            dispatcher.forward(req, resp);
        }    else if (requestURI.equals("/coursewebsite/historie")) {
        if (req.getSession().getAttribute("loggedIN") != null) {
            historyblub(req, resp);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/historie_cw");
        dispatcher.forward(req, resp);
    }


    }
}
