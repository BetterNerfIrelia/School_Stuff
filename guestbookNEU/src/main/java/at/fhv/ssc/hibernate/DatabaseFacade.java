package at.fhv.ssc.hibernate;

import at.fhv.ssc.dao.GuestentryDAO;
import at.fhv.ssc.pojo.Guestentry;

import java.util.List;

public class DatabaseFacade {

    public void safeGuestEntry(Guestentry entity){
        GuestentryDAO dao = GuestentryDAO.getInstance();
        dao.safe(entity);
    }

    public void safeGuestEntry(String name, String email, String comment){
        Guestentry entry = new Guestentry();
        entry.setName(name);
        entry.setEmail(email);
        entry.setComment(comment);
        safeGuestEntry(entry);
    }

    public Guestentry loadGuestentry(int id){
        GuestentryDAO dao = GuestentryDAO.getInstance();
        return dao.load(id);
    }

    public List<Guestentry> loadAllGuestentry() {
        GuestentryDAO dao = GuestentryDAO.getInstance();
        return dao.loadAll();
    }

    public void tearDownGuestentry() {
        GuestentryDAO dao = GuestentryDAO.getInstance();
        dao.tearDown();
    }



}
