package com.epam.jwd.repository;

public interface Repository<T> {
    void create(T t);
    T read(int index);
    void update(T t);
    void delete(int index);
}
