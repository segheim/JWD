package com.epam.jwd.register;

public interface Observer<T> {

    void handleEvent(T t);
}
