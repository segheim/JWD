package com.epam.jwd;

import com.epam.jwd.action.*;
import com.epam.jwd.additional.CreatorDotsFromFile;
import com.epam.jwd.entity.Tetrahedron;


import java.io.IOException;
import java.util.List;

public class App {

    public static void main( String[] args ) throws IOException {

        CreatorDotsFromFile creatorDotsFromFile = new CreatorDotsFromFile();
        List a = creatorDotsFromFile.createDotsFromFile();
        Tetrahedron tetrahedron = new Tetrahedron(a);
        SurfaceAreaTetrahedron surfaceAreaTetrahedron = new SurfaceAreaTetrahedron();
        System.out.println(surfaceAreaTetrahedron.calculateSurfaceAreaTetrahedron(tetrahedron));
        VolumeTetrahedron volumeTetrahedron = new VolumeTetrahedron();
        System.out.println(volumeTetrahedron.calculateVolumeTetrahedron(tetrahedron));
        CheckerTetrahedron checkerTetrahedron = new CheckerTetrahedron(tetrahedron);


    }
}
