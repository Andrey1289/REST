package andrey.service;

import andrey.model.User;
import andrey.repository.UserRepository;
import andrey.repository.hibernate.HibernateUserRepositoryImpl;

import java.util.List;

public class UserService implements UserRepository {
    private final UserRepository userRepo;

    public UserService(){
        userRepo= new HibernateUserRepositoryImpl();
    }

    @Override
    public List<User> getAll() {
        return userRepo.getAll();
    }

    @Override
    public User getById(Long aLong) {
        return userRepo.getById(aLong);
    }

    @Override
    public void delete(Long aLong) {
        userRepo.delete(aLong);
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User update(User user) {
        return userRepo.update(user);
    }
}
