package at.fhv.ssc.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //TODO: Alle Cookies einlesen, Cookie adresse suchen, auslesen, redirect zu adresse. WEB:XML das servlet und rest schauen was fehlt.

        Cookie[] cookies = null;
        cookies = req.getCookies();
        String url = "/coursewebsite/bilder";


        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("adresse")) {
                    url = c.getValue();
                }
            }
        }
        resp.sendRedirect(url);
    }
}
