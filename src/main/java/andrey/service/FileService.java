package andrey.service;

import andrey.model.File;
import andrey.repository.FileRepository;
import andrey.repository.hibernate.HibernateFileRepositoryImpl;

import java.util.List;

public class FileService implements FileRepository {
    private final FileRepository fileRepo;

    public FileService(){
        fileRepo = new HibernateFileRepositoryImpl();
    }

    @Override
    public List<File> getAll() {
        return fileRepo.getAll();
    }

    @Override
    public File getById(Long aLong) {
        return fileRepo.getById(aLong);
    }

    @Override
    public void delete(Long aLong) {
        fileRepo.delete(aLong);
    }

    @Override
    public File save(File file) {
        return fileRepo.save(file);
    }

    @Override
    public File update(File file) {
        return fileRepo.update(file);

    }
}
