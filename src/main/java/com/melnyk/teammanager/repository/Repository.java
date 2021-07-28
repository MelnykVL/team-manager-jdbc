package com.melnyk.teammanager.repository;

import java.util.List;

public interface Repository<T, ID> {
    T getById(ID id);
    T add(T t);
    T update(T t);
    void removeById(ID id);

    List<T> getAll();
}
