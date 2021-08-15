package com.epam.jwd.repository;

import com.epam.jwd.entity.Tetrahedron;

import java.util.*;

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

    public List<Tetrahedron> searchTetrahedronsById(int minId, int maxId) {
        List<Tetrahedron> tetrahedronsById = new ArrayList<>();

        for (Tetrahedron tetrahedron : tetrahedronList) {
            if (tetrahedron.getTetrahedronId() >= minId && tetrahedron.getTetrahedronId() <= maxId) {
                tetrahedronsById.add(tetrahedron);
            }
        }
        return tetrahedronsById;
    }

    public List<Tetrahedron> searchTetrahedronsWithNegativeCoordinatesOfTop() {
        List<Tetrahedron> tetrahedronsWithNegativeCoordinatesOfTop = new ArrayList<>();

        for (Tetrahedron tetrahedron : tetrahedronList) {
            if (tetrahedron.getVertexDots().get(3).getX() < 0 || tetrahedron.getVertexDots().get(3).getY() < 0
            || tetrahedron.getVertexDots().get(3).getZ() < 0) {
                tetrahedronsWithNegativeCoordinatesOfTop.add(tetrahedron);
            }
        }
        return tetrahedronsWithNegativeCoordinatesOfTop;
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
