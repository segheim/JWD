package com.epam.jwd.register;

public interface Observable {

    void addRegister(Observer observer);
    void removeRegister(Observer observer);
    void notifyRegisters();
}
