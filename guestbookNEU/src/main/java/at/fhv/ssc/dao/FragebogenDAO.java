package at.fhv.ssc.dao;

import at.fhv.ssc.pojo.Fragebogen;

public class FragebogenDAO extends BaseDAO<Fragebogen, String> {


    private static FragebogenDAO _instance;

    private FragebogenDAO(){

        super(Fragebogen.class);
    }

    public static FragebogenDAO getInstance(){
        if(_instance==null){
            _instance = new FragebogenDAO();
        }
        return _instance;
    }


}
