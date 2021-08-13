package com.epam.jwd.register;

import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.ShapeTetrahedron;
import com.epam.jwd.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.List;

public class ChangerCoordinatesTetrahedron implements Observable {

    List<Observer> registers = new ArrayList<>();
    Tetrahedron tetrahedron;

    public ChangerCoordinatesTetrahedron(Tetrahedron tetrahedron) {
        this.tetrahedron = tetrahedron;
    }

    public ShapeTetrahedron changeCoordinatesTetrahedron(int indexVertexForChange, Dot changeDot) {

        if (indexVertexForChange > 0 && indexVertexForChange <= 4) {
            List<Dot> vertexes = tetrahedron.getVertexDots();
            vertexes.set(indexVertexForChange, changeDot);
            tetrahedron.setVertexDots(vertexes);
        }
        notifyRegisters();

        return tetrahedron;
    }

    @Override
    public void addRegister(Observer observer) {
        registers.add(observer);
    }

    @Override
    public void removeRegister(Observer observer) {
        registers.remove(observer);
    }

    @Override
    public void notifyRegisters() {
        for (Observer register: registers){
            register.handleEvent(tetrahedron);
        }

    }
}
