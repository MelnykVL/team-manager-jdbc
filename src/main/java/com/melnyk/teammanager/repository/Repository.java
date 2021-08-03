package com.melnyk.teammanager.repository;

import java.util.List;

public interface Repository<T, ID> {
    T getById(ID id);
    T add(T t);
    T update(T t);
    boolean removeById(ID id);

    List<T> getAll();
}
