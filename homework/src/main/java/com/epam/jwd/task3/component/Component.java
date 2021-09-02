package com.epam.jwd.task3.component;

public interface Component {

    void addComponent(Component component);
    void removeComponent(Component component);
    String print();
}
