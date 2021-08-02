package com.melnyk.teammanager.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {
    T getById(ID id);
    boolean add(T t);
    boolean update(T t);
    boolean removeById(ID id);

    List<T> getAll();
}
