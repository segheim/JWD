package com.epam.jwd.task3.component;

import java.util.ArrayList;
import java.util.List;

public class Word implements Component{

    List<Component> components = new ArrayList<>();

    @Override
    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public void removeComponent(Component component) {
        components.add(component);
    }

    @Override
    public String print() {
        return null;
    }
}
