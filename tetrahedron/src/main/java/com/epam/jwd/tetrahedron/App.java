package com.epam.jwd.tetrahedron;

import com.epam.jwd.tetrahedron.action.CheckerBaseTetrahedronOnCoordinatePlane;
import com.epam.jwd.tetrahedron.action.CheckerTetrahedron;
import com.epam.jwd.tetrahedron.action.SurfaceAreaTetrahedron;
import com.epam.jwd.tetrahedron.action.VolumeTetrahedron;
import com.epam.jwd.tetrahedron.additional.CreatorDotsFromFile;
import com.epam.jwd.tetrahedron.entity.Tetrahedron;


import java.io.IOException;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws IOException {

        CreatorDotsFromFile creatorDotsFromFile = new CreatorDotsFromFile();
        List a = creatorDotsFromFile.createDotsFromFile();
        Tetrahedron tetrahedron = new Tetrahedron(a);
        SurfaceAreaTetrahedron surfaceAreaTetrahedron = new SurfaceAreaTetrahedron();
        System.out.println(surfaceAreaTetrahedron.calculateSurfaceAreaTetrahedron(tetrahedron));
        VolumeTetrahedron volumeTetrahedron = new VolumeTetrahedron();
        System.out.println(volumeTetrahedron.calculateVolumeTetrahedron(tetrahedron));
        CheckerTetrahedron checkerTetrahedron = new CheckerTetrahedron();
        System.out.println(checkerTetrahedron.isTetrahedron(tetrahedron));
        CheckerBaseTetrahedronOnCoordinatePlane checkerBaseTetrahedronOnCoordinatePlane = new CheckerBaseTetrahedronOnCoordinatePlane();
        System.out.println(checkerBaseTetrahedronOnCoordinatePlane.isBaseTetrahedronOnCoordinatePlane(tetrahedron));


    }
}
