package andrey.repository.hibernate;

import andrey.model.Event;
import andrey.repository.EventRepository;
import andrey.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class HibernateEventRepositoryImpl implements EventRepository {
    @Override
    public List<Event> getAll() {
        try(Session session = HibernateUtils.getSession()) {
            return (List<Event>)session.createQuery("From Event").list();
        }
    }

    @Override
    public Event getById(Long aLong) {
        Session session = HibernateUtils.getSession();
        Event event = session.get(Event.class, aLong);

        return event;
    }

    @Override
    public void delete(Long aLong) {
        Session session = HibernateUtils.getSession();
        Event event = session.get(Event.class,aLong);
        session.delete(event);

    }

    @Override
    public Event save(Event event) {
        Session session = HibernateUtils.getSession();
        session.save(event);

        return event;
    }

    @Override
    public Event update(Event event) {
        Session session = HibernateUtils.getSession();
        session.update(event);
        return event;
    }
}
