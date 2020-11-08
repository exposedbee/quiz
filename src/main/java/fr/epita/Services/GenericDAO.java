package fr.epita.Services;

import fr.epita.exception.CreationFailedException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import java.util.List;

public abstract class GenericDAO<T> {


    @Inject
    SessionFactory sf;


    public void create(T o) throws CreationFailedException{
        Session session = sf.openSession(); //not working : getCurrentSession();

        session.save(o);

    }
    private Session getCurrentSession() {
        Session session = sf.getCurrentSession();
        if (session == null) {
            session = sf.openSession();
        }
        return session;
    }
    public void update(T o) {
        Session session = sf.openSession();
        session.update(o);
    }
    public void delete(T o) {
        Session session = sf.openSession();
        session.delete(o);
    }

    public abstract List<T> search(T criteria);

}
