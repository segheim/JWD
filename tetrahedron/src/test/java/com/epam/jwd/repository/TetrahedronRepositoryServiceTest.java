package com.epam.jwd.repository;

import com.epam.jwd.action.LengthsSidesTetrahedron;
import com.epam.jwd.action.VolumeTetrahedron;
import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;
import org.mockito.Mockito;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class TetrahedronRepositoryServiceTest {

    private Tetrahedron tetrahedron;
    private Tetrahedron tetrahedron1;
    private List<Tetrahedron> tetrahedrons;
    private TetrahedronRepositoryService tetrahedronRepositoryService;

    @BeforeTest
    public void init() {

        tetrahedronRepositoryService = new TetrahedronRepositoryService();
        tetrahedrons = new ArrayList<>();

        List<Dot> dots = new ArrayList<>();
        dots.add(new Dot(2.5, 4, 5));
        dots.add(new Dot(2.5, 10, 5));
        dots.add(new Dot(2.5, 4, 8));
        dots.add(new Dot(5, 4, 5));

        tetrahedron = new Tetrahedron(dots);
        tetrahedrons.add(tetrahedron);

        List<Dot> dots1 = new ArrayList<>();
        dots1.add(new Dot(2.5, 4, 5));
        dots1.add(new Dot(2.5, 10, 5));
        dots1.add(new Dot(2.5, 4, 8));
        dots1.add(new Dot(5, 4, 5));

        tetrahedron1 = new Tetrahedron(dots1);
        tetrahedrons.add(tetrahedron1);

        tetrahedronRepositoryService.create(tetrahedron);
        tetrahedronRepositoryService.create(tetrahedron1);
    }

    @Test
    public void getAllVolumeTest_shouldReturnListVolumes_always(){

        List<Double> actual = new ArrayList<>();
        actual.add(7.5);
        actual.add(7.5);

        List<Double> expected = tetrahedronRepositoryService.getAllVolume();

        assertEquals(actual, expected);
    }
//
//    @Test
//    public void getAllPerimetersTest_shouldReturnListVolumes_always() {
//
//        List<Double> actual = new ArrayList<>();
//        List<Double> expected = new ArrayList<>();
//        LengthsSidesTetrahedron lengthsSidesTetrahedron = Mockito.mock(LengthsSidesTetrahedron.class);
//
//        actual.add(0.0);
//
//        for (Tetrahedron tetrahedron : tetrahedrons) {
//            Map<String, Double> lengthSides = lengthsSidesTetrahedron.calculateLengthsSidesTetrahedron(tetrahedron);
//            System.out.println(volume);
//            expected.add(volume);
//        }
//        assertEquals(actual, expected);
//
//    }

//    public void createTest_



}
