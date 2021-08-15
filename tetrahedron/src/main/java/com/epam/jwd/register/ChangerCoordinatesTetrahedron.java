package com.epam.jwd.register;

import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;
import com.epam.jwd.repository.TetrahedronRepository;

import java.util.ArrayList;
import java.util.List;

public class ChangerCoordinatesTetrahedron implements Observable {

    private List<Observer> registers = new ArrayList<>();
    private Tetrahedron tetrahedron;

    public void changeCoordinatesTetrahedronInRepository(Integer tetrahedronId, int indexVertexForChange, Dot changeDot) {

        tetrahedron = TetrahedronRepository.getTetrahedronRepository().read(tetrahedronId);
        List<Dot> vertexes = tetrahedron.getVertexDots();
        vertexes.set(indexVertexForChange, changeDot);
        tetrahedron.setVertexDots(vertexes);
        TetrahedronRepository.getTetrahedronRepository().update(tetrahedronId, tetrahedron);
        notifyRegisters();
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
