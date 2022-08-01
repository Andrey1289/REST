package andrey.repository.hibernate;

import andrey.model.Event;
import andrey.model.User;
import andrey.repository.UserRepository;
import andrey.utils.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

public class HibernateUserRepositoryImpl implements UserRepository {
    @Override
    public List<User> getAll() {
      try(Session session = HibernateUtils.getSession()) {
          return (List<User>) session.createQuery("From User").list();
      }
    }

    @Override
    public User getById(Long aLong) {
        Session session = HibernateUtils.getSession();
        User user = session.get(User.class,aLong);

        return user;
    }

    @Override
    public void delete(Long aLong) {
        Session session = HibernateUtils.getSession();
        User user = session.get(User.class,aLong);
        session.delete(user);

    }
// проверь метод save
    @Override
    public User save(User user) {
       try(Session session = HibernateUtils.getSession()){
           Query query = (Query) session.createQuery("From Event WHERE event_id = id");
           query.setParameter("id", user.getId());
          List<Event> evens= (List<Event>) query.getResultStream().collect(Collectors.toList());
           user.setEvents(evens);
           session.save(user);
           return user;
       }
    }
//проверь метод update
    @Override
    public User update(User user) {
        try(Session session = HibernateUtils.getSession()){
            Query query = (Query) session.createQuery("From Event WHERE event_id = id");
            query.setParameter("id", user.getId());
            List<Event> evens= (List<Event>) query.getResultStream().collect(Collectors.toList());
            user.setEvents(evens);
            session.update(user);
            return user;
        }
    }
}
