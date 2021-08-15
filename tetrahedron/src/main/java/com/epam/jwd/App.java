package com.epam.jwd;

import com.epam.jwd.additional.CreatorDotsFromFile;
import com.epam.jwd.additional.CreatorTetrahedron;
import com.epam.jwd.entity.Tetrahedron;
import com.epam.jwd.repository.Repository;
import com.epam.jwd.repository.TetrahedronRepository;


import java.io.IOException;
import java.util.List;

public class App {

    public static void main( String[] args ) throws IOException {

        CreatorDotsFromFile creatorDotsFromFile = new CreatorDotsFromFile();

        List a = creatorDotsFromFile.createDotsFromFile();


        List dot = creatorDotsFromFile.getDotsForTetrahedrons();
        System.out.println(dot.toString());


        CreatorTetrahedron creatorTetrahedron = new CreatorTetrahedron(creatorDotsFromFile);


        TetrahedronRepository.getTetrahedronRepository().sortById();


        TetrahedronRepository.getTetrahedronRepository().sortByCoordinateXFirstDot();
        System.out.println(TetrahedronRepository.getTetrahedronRepository().getTetrahedronList());

        TetrahedronRepository.getTetrahedronRepository().sortByCoordinateYFirstDot();
        System.out.println(TetrahedronRepository.getTetrahedronRepository().getTetrahedronList());


    }
}
