package at.fhv.ssc.datenmanagement_projekt;

import java.sql.SQLException;

public class Main {

public static void main(String[] args) throws SQLException{

    DatabaseFacade test = new DatabaseFacade();
    test.getConnection("jdbc:postgresql://localhost:5432/myDB", "postgres", "postgres");


}

}

