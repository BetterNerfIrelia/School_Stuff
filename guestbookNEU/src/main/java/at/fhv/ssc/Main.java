package at.fhv.ssc;

import at.fhv.ssc.hibernate.DatabaseFacade;
import at.fhv.ssc.pojo.Guestentry;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DatabaseFacade facade = new DatabaseFacade();

        Guestentry entry = new Guestentry();
        entry.setName("TestName");
        entry.setEmail("test@test.test");
        entry.setComment("this is a test");

        facade.safeGuestEntry(entry);
        List<Guestentry> list = facade.loadAllGuestentry();

        for(Guestentry e : list){
            System.out.println("id: " + e.getId());
            System.out.println("name: " + e.getName());
            System.out.println("email: " + e.getEmail());
            System.out.println("comment: " + e.getComment());
        }



    }

}
