package at.fhv.ssc.dao;

        import at.fhv.ssc.pojo.Guestentry;
        import at.fhv.ssc.pojo.Userentry;
        import org.hibernate.Session;

        import javax.persistence.criteria.CriteriaBuilder;
        import javax.persistence.criteria.CriteriaQuery;
        import javax.persistence.criteria.Root;
        import java.util.List;

public class UserentryDAO extends  BaseDAO<Userentry, String>{

    private static UserentryDAO _instance;

    private UserentryDAO(){

        super(Userentry.class);
    }

    public static UserentryDAO getInstance(){
        if(_instance==null){
            _instance = new UserentryDAO();
        }
        return _instance;
    }


    }


