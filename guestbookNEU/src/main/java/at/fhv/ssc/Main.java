package at.fhv.ssc;

import at.fhv.ssc.hibernate.DatabaseFacade;
import at.fhv.ssc.mojo.UserBean;
import at.fhv.ssc.pojo.Guestentry;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DatabaseFacade facade = new DatabaseFacade();

        UserBean bean = new UserBean("skoiia", "sebastian", "schiener", "passwort", "admin");
        bean.saveUser();
        facade.tearDownUserentry();






    }

}
