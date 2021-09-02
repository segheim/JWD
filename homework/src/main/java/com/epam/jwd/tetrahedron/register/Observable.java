package com.epam.jwd.register;

public interface Observable<R> {

    void addRegister(Observer observer);
    void removeRegister(Observer observer);
    void notifyRegisters(R r);
}
