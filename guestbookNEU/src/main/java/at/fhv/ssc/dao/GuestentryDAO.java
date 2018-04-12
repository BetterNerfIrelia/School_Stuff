package at.fhv.ssc.dao;

import at.fhv.ssc.pojo.Guestentry;

public class GuestentryDAO extends  BaseDAO<Guestentry, Integer>{

    private static GuestentryDAO _instance;



    private GuestentryDAO(){

        super(Guestentry.class);
    }

    public static GuestentryDAO getInstance(){
        if(_instance==null){
            _instance = new GuestentryDAO();
        }
        return _instance;

    }


}