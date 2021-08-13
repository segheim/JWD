package com.epam.jwd.register;

import com.epam.jwd.entity.ShapeTetrahedron;

public interface Observer {

    void handleEvent(ShapeTetrahedron tetrahedron);
}
