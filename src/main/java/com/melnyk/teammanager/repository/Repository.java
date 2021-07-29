package com.melnyk.teammanager.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {
    Optional<T> getById(ID id);
    T add(T t);
    T update(T t);
    void removeById(ID id);

    List<T> getAll();
}
