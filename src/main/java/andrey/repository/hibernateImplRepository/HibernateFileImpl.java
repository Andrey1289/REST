package andrey.repository.hibernateImplRepository;

import andrey.model.File;
import andrey.repository.FileRepository;
import andrey.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class HibernateFileImpl implements FileRepository {
    @Override
    public List<File> getAll() {
        Session session = HibernateUtils.getSession();
        List<File> files = session.createQuery("From File").list();
        HibernateUtils.closeSession(session);
        return files;
    }

    @Override
    public File getById(Long aLong) {
        Session session = HibernateUtils.getSession();
        File file = session.get(File.class,aLong);
        HibernateUtils.closeSession(session);
        return null;
    }

    @Override
    public void delete(Long aLong) {
        Session session = HibernateUtils.getSession();
        File file = session.get(File.class,aLong);
        session.delete(file);
        HibernateUtils.closeSession(session);
    }

    @Override
    public File save(File file) {
        Session session = HibernateUtils.getSession();
        session.save(file);
        HibernateUtils.closeSession(session);
        return file;
    }

    @Override
    public File update(File file) {
        Session session = HibernateUtils.getSession();
        session.update(file);
        HibernateUtils.closeSession(session);
        return file;
    }
}
