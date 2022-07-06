package andrey.repository.hibernateImplRepository;

import andrey.model.User;
import andrey.repository.UserRepository;
import andrey.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class HibernateUserImpl implements UserRepository {
    @Override
    public List<User> getAll() {
        Session session = HibernateUtils.getSession();
        List<User> users = session.createQuery("From User").list();
        HibernateUtils.closeSession(session);
        return users;
    }

    @Override
    public User getById(Long aLong) {
        Session session = HibernateUtils.getSession();
        User user = session.get(User.class,aLong);
        HibernateUtils.closeSession(session);
        return user;
    }

    @Override
    public void delete(Long aLong) {
        Session session = HibernateUtils.getSession();
        User user = session.get(User.class,aLong);
        session.delete(user);
        HibernateUtils.closeSession(session);
    }

    @Override
    public User save(User user) {
        Session session = HibernateUtils.getSession();
        session.save(user);
        HibernateUtils.closeSession(session);
        return user;
    }

    @Override
    public User update(User user) {
        Session session = HibernateUtils.getSession();
        session.update(user);
        HibernateUtils.closeSession(session);
        return user;
    }
}
