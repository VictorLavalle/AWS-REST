package com.aws.rest.DAO;

import java.util.List;

public interface DAOEntity<T> {

    T get(long id);

    List<T> getAll();

    boolean update(long id , T t);

    boolean save(T t);

    boolean delete(long id);

}
