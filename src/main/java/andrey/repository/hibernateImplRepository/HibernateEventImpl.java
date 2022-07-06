package andrey.repository.hibernateImplRepository;

import andrey.model.Event;
import andrey.repository.EventRepository;
import andrey.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class HibernateEventImpl implements EventRepository {
    @Override
    public List<Event> getAll() {
        Session session =  HibernateUtils.getSession();
        List<Event> eventList = session.createQuery("From Event").list();
        HibernateUtils.closeSession(session);
        return eventList;
    }

    @Override
    public Event getById(Long aLong) {
        Session session = HibernateUtils.getSession();
        Event event = session.get(Event.class, aLong);
        HibernateUtils.closeSession(session);
        return event;
    }

    @Override
    public void delete(Long aLong) {
        Session session = HibernateUtils.getSession();
        Event event = session.get(Event.class,aLong);
        session.delete(event);
        HibernateUtils.closeSession(session);
    }

    @Override
    public Event save(Event event) {
        Session session = HibernateUtils.getSession();
        session.save(event);
        HibernateUtils.closeSession(session);
        return event;
    }

    @Override
    public Event update(Event event) {
        Session session = HibernateUtils.getSession();
        session.update(event);
        return event;
    }
}
