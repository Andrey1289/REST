package andrey.repository.hibernate;

import andrey.model.File;
import andrey.repository.FileRepository;
import andrey.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class HibernateFileRepositoryImpl implements FileRepository {
    @Override
    public List<File> getAll() {
        try(Session session = HibernateUtils.getSession()) {
            return (List<File>) session.createQuery("From File").list();
        }
    }

    @Override
    public File getById(Long aLong) {
        Session session = HibernateUtils.getSession();
        File file = session.get(File.class,aLong);

        return null;
    }

    @Override
    public void delete(Long aLong) {
        Session session = HibernateUtils.getSession();
        File file = session.get(File.class,aLong);
        session.delete(file);

    }

    @Override
    public File save(File file) {
        Session session = HibernateUtils.getSession();
        session.save(file);

        return file;
    }

    @Override
    public File update(File file) {
        Session session = HibernateUtils.getSession();
        session.update(file);

        return file;
    }
}
