package com.epam.jwd;


import com.epam.jwd.additional.ShapeTetrahedronFactory;
import com.epam.jwd.additional.TetrahedronFactory;
import com.epam.jwd.entity.Tetrahedron;
import com.epam.jwd.repository.TetrahedronRepositoryServiceFactory;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main( String[] args ) throws IOException {


        ShapeTetrahedronFactory shapeTetrahedronFactory = new TetrahedronFactory();
        TetrahedronFactory tetrahedronFactory = new TetrahedronFactory();
        List<Tetrahedron> tetrahedrons = tetrahedronFactory.createTetrahedrons();
        System.out.println(tetrahedrons);
        for (Tetrahedron tetrahedron : tetrahedrons) {
            TetrahedronRepositoryServiceFactory.getTetrahedronRepositoryService().create(tetrahedron);
        }
        System.out.println(TetrahedronRepositoryServiceFactory.getTetrahedronRepositoryService().getAllVolume());


    }
}
