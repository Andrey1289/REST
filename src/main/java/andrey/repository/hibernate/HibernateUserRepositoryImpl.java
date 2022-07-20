package andrey.repository.hibernate;

import andrey.model.User;
import andrey.repository.UserRepository;
import andrey.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

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

    @Override
    public User save(User user) {
        Session session = HibernateUtils.getSession();
        session.save(user);
        return user;
    }

    @Override
    public User update(User user) {
        Session session = HibernateUtils.getSession();
        session.update(user);
        return user;
    }
}
