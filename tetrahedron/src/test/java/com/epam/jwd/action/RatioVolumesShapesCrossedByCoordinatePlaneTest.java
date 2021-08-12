package com.epam.jwd.action;

import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class RatioVolumesShapesCrossedByCoordinatePlaneTest {

    private List<Dot> dots;
    private List<Dot> dots1;
    private List<Dot> dots2;
    private List<Dot> dots3;
    private Tetrahedron tetrahedron;
    private Tetrahedron tetrahedron1;
    private Tetrahedron tetrahedron2;
    private Tetrahedron tetrahedron3;

    @BeforeClass
    public void init() {
        dots = new ArrayList();
        dots.add(new Dot(5,-3, 3));
        dots.add(new Dot(5,8, 3));
        dots.add(new Dot(5,-3, 6));
        dots.add(new Dot(10,-3, 3));
        tetrahedron = new Tetrahedron(dots);

        dots1 = new ArrayList();
        dots1.add(new Dot(0,2, 3));
        dots1.add(new Dot(0,8, 3));
        dots1.add(new Dot(0,2, 6));
        dots1.add(new Dot(10,2, 3));
        tetrahedron1 = new Tetrahedron(dots1);

        dots2 = new ArrayList();
        dots2.add(new Dot(-3,2, 2));
        dots2.add(new Dot(-3,5, 2));
        dots2.add(new Dot(-3,2, 8));
        dots2.add(new Dot(4,2, 3));
        tetrahedron2 = new Tetrahedron(dots2);

        dots3 = new ArrayList();
        dots3.add(new Dot(2,3, -5));
        dots3.add(new Dot(2,8, -5));
        dots3.add(new Dot(2,3, 6));
        dots3.add(new Dot(8,3, -5));
        tetrahedron3 = new Tetrahedron(dots3);
    }

    @Test(dataProvider = "DataCheckRationTetrahedron")
    public void calculateRatioVolumesShapesCrossedByCoordinatePlaneTest(int actual, Tetrahedron tetrahedron) {
        int expected = (int) Math.round(RatioVolumesShapesCrossedByCoordinatePlane.calculateRatioVolumesShapesCrossedByCoordinatePlane(tetrahedron));
        assertEquals(actual, expected);
    }

    @DataProvider(name = "DataCheckRationTetrahedron")
    public Object[][] checkRationTest(){
        return new Object[][]{{2, tetrahedron},
                {0, tetrahedron1},
                {4, tetrahedron2},
                {5, tetrahedron3}
        };
    }
}
