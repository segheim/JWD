package com.epam.jwd.register;

import com.epam.jwd.action.SurfaceAreaTetrahedron;
import com.epam.jwd.action.VolumeTetrahedron;
import com.epam.jwd.entity.ShapeTetrahedron;
import com.epam.jwd.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterTetrahedron implements Observer{

    Integer indexTetrahedron = 0;
    private Map<Integer, List<Double>> register;
    List<Double> parameters;

    public RegisterTetrahedron(Map<Integer, List<Double>> register) {
        this.register = new HashMap<>();
        parameters = new ArrayList<>();
    }


    @Override
    public void handleEvent(ShapeTetrahedron tetrahedron) {
        register.put(indexTetrahedron, calculateParameters(tetrahedron));
    }

    public Integer addTetrahedron(Tetrahedron tetrahedron) {
        register.put(++indexTetrahedron, calculateParameters(tetrahedron));
        return indexTetrahedron;
    }

    private List<Double> calculateParameters(ShapeTetrahedron tetrahedron) {

        List<Double> parameters = new ArrayList<>();
        SurfaceAreaTetrahedron surfaceAreaTetrahedron = new SurfaceAreaTetrahedron();
        Double surfaceArea = surfaceAreaTetrahedron.calculateSurfaceAreaTetrahedron((Tetrahedron)tetrahedron);

        VolumeTetrahedron volumeTetrahedron = new VolumeTetrahedron();
        Double volume = volumeTetrahedron.calculateVolumeTetrahedron((Tetrahedron)tetrahedron);

        parameters.add(surfaceArea);
        parameters.add(volume);

        return parameters;
    }
}
