package at.fhv.ssc.dao;

import at.fhv.ssc.pojo.Guestentry;
import at.fhv.ssc.pojo.Userentry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class BaseDAO<T,  PK extends Serializable> {

    private Class<T> _type;
    private SessionFactory _factory;

    public BaseDAO (Class<T> type){

        _type = type;

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Guestentry.class);
        conf.addAnnotatedClass(Userentry.class);


        StandardServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

        _factory= conf.buildSessionFactory(sr);

    }

    public void safe(T entity){
        Session s = getSession();
        Transaction t = s.beginTransaction();
        s.save(entity);
        t.commit();
        s.close();
        System.out.println("Entry saved");
    }

    public T load(PK id){
        Session s = getSession();
        T entity = s.get(_type,id);
        s.close();
        return entity;
    }

    public List<T> loadAll(){
        Session s = getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<T> crit = builder.createQuery(_type);
        crit.from(_type);

        List<T> entities = s.createQuery(crit).getResultList();
        s.close();
        return entities;
    }

    public void tearDown(){
        _factory.close();
    }

    protected Session getSession(){
        return _factory.openSession();
    }


}
