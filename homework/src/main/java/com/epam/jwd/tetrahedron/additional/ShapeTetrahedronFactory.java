package com.epam.jwd.additional;

import com.epam.jwd.entity.Tetrahedron;

import java.io.IOException;
import java.util.List;

public interface ShapeTetrahedronFactory<Tetrahedron> {

    List<Tetrahedron> createTetrahedrons() throws IOException;
}
