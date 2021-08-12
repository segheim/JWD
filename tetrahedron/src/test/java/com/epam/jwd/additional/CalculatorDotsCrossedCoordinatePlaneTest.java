package com.epam.jwd.additional;

import com.epam.jwd.entity.Dot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDotsCrossedCoordinatePlaneTest {

   @Test(dataProvider = "DataCrossedPlaneX")
    public void calculateDotsCrossedCoordinatePlaneXTest(Dot actual, Dot expected1, Dot expected2) {
       Dot expected = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneX(expected1, expected2);
       assertEquals(actual, expected);
   }

    @DataProvider(name = "DataCrossedPlaneX")
    public Object[][] checkPlaneXTest(){
        return new Object[][]{{new Dot(0, 5, 5.5), new Dot(5, 6, 3),
                new Dot(-5, 4, 8)},
                {new Dot(0, 7, -4), new Dot(-4, 8, -3),
                        new Dot(12, 4, -7)}
        };
    }

    @Test(dataProvider = "DataCrossedPlaneY")
    public void calculateDotsCrossedCoordinatePlaneYTest(Dot actual, Dot expected1, Dot expected2) {
        Dot expected = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneY(expected1, expected2);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "DataCrossedPlaneY")
    public Object[][] checkPlaneYTest(){
        return new Object[][]{{new Dot(3, 0, 7), new Dot(5, -6, 3),
                new Dot(2, 3, 9)},
                {new Dot(9, 0, 3), new Dot(3, 8, 3),
                        new Dot(12, -4, 3)}
        };
    }

    @Test(dataProvider = "DataCrossedPlaneZ")
    public void calculateDotsCrossedCoordinatePlaneZTest(Dot actual, Dot expected1, Dot expected2) {
        Dot expected = CalculatorDotsCrossedCoordinatePlane.calculateDotsCrossedCoordinatePlaneZ(expected1, expected2);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "DataCrossedPlaneZ")
    public Object[][] checkPlaneZTest(){
        return new Object[][]{{new Dot(6, 5, 0), new Dot(5, 6, -2),
                new Dot(8, 3, 4)},
                {new Dot(9, 4, 0), new Dot(3, 2, -8),
                        new Dot(12, 5, 4)}
        };
    }

}
