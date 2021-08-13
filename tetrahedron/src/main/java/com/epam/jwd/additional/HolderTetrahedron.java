package com.epam.jwd.additional;

import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.List;

public class HolderTetrahedron {

    List<Tetrahedron> tetrahedrons;

    public HolderTetrahedron() {
        this.tetrahedrons = new ArrayList<>();
    }

    public void addTetrahedronToHolder(List<Dot> dots) {

        Tetrahedron tetrahedron = new Tetrahedron(dots);
        tetrahedrons.add(tetrahedron);
    }

    public List<Tetrahedron> getTetrahedrons() {
        return tetrahedrons;
    }
}
