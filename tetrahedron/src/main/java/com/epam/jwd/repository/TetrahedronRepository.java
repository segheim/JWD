package com.epam.jwd.repository;

import com.epam.jwd.entity.Tetrahedron;

import java.util.*;
import java.util.function.Function;

public class TetrahedronRepository implements Repository<Tetrahedron> {

    private static TetrahedronRepository tetrahedronRepository;
    private List<Tetrahedron> tetrahedronList;

    private TetrahedronRepository() {
        tetrahedronList = new ArrayList<>();
    }

    public static TetrahedronRepository getTetrahedronRepository() {
        if (tetrahedronRepository == null) {
            tetrahedronRepository = new TetrahedronRepository();
        }
        return tetrahedronRepository;
    }

    public List<Tetrahedron> getTetrahedronList() {
        return tetrahedronList;
    }

    public void sortById() {
        tetrahedronList.sort(Comparator.comparing(Tetrahedron::getTetrahedronId));
    }

    public void sortByCoordinateXFirstDot() {
        tetrahedronList.sort(Comparator.comparingDouble(tetrahedron -> tetrahedron.getVertexDots().get(1).getX()));
    }

    public void sortByCoordinateYFirstDot() {
        tetrahedronList.sort(Comparator.comparingDouble(tetrahedron -> tetrahedron.getVertexDots().get(1).getY()));
    }


    @Override
    public void create(Tetrahedron tetrahedron) {
        tetrahedronList.add(tetrahedron);
    }

    @Override
    public Tetrahedron read(int index) {
        return tetrahedronList.get(index);
    }

    @Override
    public void update(int index, Tetrahedron tetrahedron) {
        tetrahedronList.set(index, tetrahedron);
    }

    @Override
    public void delete(int index) {
        tetrahedronList.remove(index);
    }


}
