package andrey.repository;

import java.util.List;

public interface GenericRepository <T,ID>{
    List<T> getAll();
    T getById(ID id);
    void delete(ID id);
    T save(T t);
    T update(T t);
}
