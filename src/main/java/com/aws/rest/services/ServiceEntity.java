package com.aws.rest.services;

import java.util.List;

public interface ServiceEntity<T> {

    T get(long id);

    List<T> getAll();

    boolean update(long id, T t);

    boolean save(T t);

    boolean delete(long id);

}
