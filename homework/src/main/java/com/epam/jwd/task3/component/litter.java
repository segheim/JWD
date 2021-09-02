package com.epam.jwd.task3.component;

public class litter implements Component{

    @Override
    public void addComponent(Component component) {
        throw new UnsupportedOperationException("This method cannot be used in litter!");
    }

    @Override
    public void removeComponent(Component component) {
        throw new UnsupportedOperationException("This method cannot be used in litter!");
    }

    @Override
    public String print() {
        return null;
    }
}
