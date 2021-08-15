package com.epam.jwd.repository;

public interface Repository<T> {
    String toString();

    void create(T t);
    T read(int index);
    void update(int index, T t);
    void delete(int index);
}
