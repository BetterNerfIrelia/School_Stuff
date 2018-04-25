package at.fhv.ssc.datenmanagement_projekt;

import java.sql.*;

public class DatabaseFacade {

    private Connection _c;

    public Connection getConnection(String connection, String user, String password){
        try {
            _c = DriverManager.getConnection(connection, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _c;
    }

    public ResultSet getAllReservations(){
        try{Statement stmt = _c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from Reservierung");
        return rs;}
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void getAllPersons(){
        try{Statement stmt = _c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from Kunde");
            while(rs.next()){
                rs.
            }

            }
        catch(SQLException e){
            e.printStackTrace();
        }
    }


    }


}
