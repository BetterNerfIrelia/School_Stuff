package at.fhv.ssc.servlets;

import at.fhv.ssc.hibernate.DatabaseFacade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EntryServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String name = req.getParameter("Name");
        String email = req.getParameter("Email");
        String comment = req.getParameter("Kommentar");

        DatabaseFacade df = new DatabaseFacade();
        df.safeGuestEntry(name, email, comment);

        resp.sendRedirect(req.getContextPath() + "/guestbook");
    }
}
