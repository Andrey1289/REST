package andrey.service;

import andrey.model.File;
import andrey.repository.FileRepository;
import andrey.repository.hibernateImplRepository.HibernateFileImpl;

import java.util.List;

public class FileService implements FileRepository {
    private final HibernateFileImpl fileRepo;

    public FileService(){
        fileRepo = new HibernateFileImpl();
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
