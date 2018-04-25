package at.fhv.ssc.hibernate;

import at.fhv.ssc.dao.FragebogenDAO;
import at.fhv.ssc.dao.GuestentryDAO;
import at.fhv.ssc.dao.UserentryDAO;
import at.fhv.ssc.pojo.Fragebogen;
import at.fhv.ssc.pojo.Guestentry;
import at.fhv.ssc.pojo.Userentry;

import java.util.List;

public class DatabaseFacade {

   public void safeFragebogen(Fragebogen entity){
       FragebogenDAO dao = FragebogenDAO.getInstance();
       dao.safe(entity);
   }

    public void safeFragebogen(String userid, String course, String coursecontent, String platform, String comment) {

        Fragebogen bogen = new Fragebogen();
        bogen.setUserid(userid);
        bogen.setCourse(course);
        bogen.setCoursecontent(coursecontent);
        bogen.setPlatform(platform);
        bogen.setComment(comment);
        safeFragebogen(bogen);
    }

    public Fragebogen loadFragebogen(String id){
        FragebogenDAO dao = FragebogenDAO.getInstance();
        return dao.load(id);
    }

    public void tearDownFragebogen() {
        FragebogenDAO dao = FragebogenDAO.getInstance();
        dao.tearDown();
    }


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

    public void safeUserEntry(Userentry entity){
        UserentryDAO dao = UserentryDAO.getInstance();
        dao.safe(entity);
    }



    public void safeUserEntry(String username, String fname, String lname, String password, String level){
        Userentry entry = new Userentry();
        entry.setUserid(username);
        entry.setFname(fname);
        entry.setLname(lname);
        entry.setPassword(password);
        entry.setLevel(level);
        safeUserEntry(entry);
    }

    public Userentry loadUserentry(String id){
        UserentryDAO dao = UserentryDAO.getInstance();
        return dao.load(id);
    }

    public List<Userentry> loadAllUserentry() {
        UserentryDAO dao = UserentryDAO.getInstance();
        return dao.loadAll();
    }

    public void tearDownUserentry() {
        UserentryDAO dao = UserentryDAO.getInstance();
        dao.tearDown();
    }





}
