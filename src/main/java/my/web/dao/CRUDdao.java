package my.web.dao;

import my.web.model.Mark;

import java.util.List;

public interface CRUDdao<T>{
    void add (T t);
    T get (int id);
    List<T> getAll();
    void update(T t);
    void delete(T t);
}
