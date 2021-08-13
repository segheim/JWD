package com.epam.jwd.action;

import static org.testng.Assert.*;

import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class CheckerTetrahedronTest {

    private List<Dot> dots;
    private List<Dot> dots1;
    private List<Dot> dots2;
    private List<Dot> dots3;
    private List<Dot> dots4;
    private Tetrahedron tetrahedron;
    private CheckerTetrahedron checkerTetrahedron;

    @BeforeClass
        public void init() {
        dots = new ArrayList();
        dots.add(new Dot(5,-3, 3));
        dots.add(new Dot(5,8, 3));
        dots.add(new Dot(5,-3, 6));
        dots.add(new Dot(10,-3, 3));
        tetrahedron = new Tetrahedron(dots);
        checkerTetrahedron = new CheckerTetrahedron(tetrahedron);

        dots1 = new ArrayList();
        dots1.add(new Dot(0,2, 3));
        dots1.add(new Dot(0,8, 3));
        dots1.add(new Dot(0,2, 6));
        dots1.add(new Dot(10,2, 3));

        dots2 = new ArrayList();
        dots2.add(new Dot(-3,2, 2));
        dots2.add(new Dot(-3,5, 2));
        dots2.add(new Dot(-3,2, 8));
        dots2.add(new Dot(4,2, 3));

        dots3 = new ArrayList();
        dots3.add(new Dot(2,3, -5));
        dots3.add(new Dot(2,8, -5));
        dots3.add(new Dot(2,3, 6));
        dots3.add(new Dot(8,3, -5));

        dots4 = new ArrayList();
        dots4.add(new Dot(0,3, -5));
        dots4.add(new Dot(0,8, -5));
        dots4.add(new Dot(0,3, 6));
        dots4.add(new Dot(8,3, -5));
    }

    @Test(dataProvider = "DataCheckTetrahedronOnCoordinatePlane")
    public void isBaseTetrahedronOnCoordinatePlaneTest(boolean actual, List<Dot> dots){
        boolean expected = checkerTetrahedron.isBaseTetrahedronOnCoordinatePlane();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "DataCheckTetrahedron")
    public void isTetrahedronTest(boolean actual, List<Dot> dots) {
        boolean expected = checkerTetrahedron.isTetrahedron();
        assertEquals(actual, expected);
    }

    @DataProvider(name = "DataCheckTetrahedron")
    public Object[][] checkTetrahedronTest(){
        return new Object[][]{{true, dots},
                {true, dots1},
                {true, dots2},
                {true, dots3}
        };
    }

    @DataProvider(name = "DataCheckTetrahedronOnCoordinatePlane")
    public Object[][] checkTetrahedronOnCoordinatePlaneTest(){
        return new Object[][]{{true, dots1},
                {true, dots4}
        };
    }
}
