package com.epam.jwd.register;

import com.epam.jwd.action.SurfaceAreaTetrahedron;
import com.epam.jwd.action.VolumeTetrahedron;
import com.epam.jwd.entity.ShapeTetrahedron;
import com.epam.jwd.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterTetrahedron implements Observer<Tetrahedron>{

    private static final Logger LOG = LogManager.getLogger(RegisterTetrahedron.class.getName());

    private static RegisterTetrahedron registerTetrahedron;
    private Map<Integer, List<Double>> register;


    private RegisterTetrahedron() {
        this.register = new HashMap<>();
    }

    public static RegisterTetrahedron getRegisterTetrahedron(){
        if (registerTetrahedron == null) {
            registerTetrahedron = new RegisterTetrahedron();
        }
        return registerTetrahedron;
    }

    @Override
    public void handleEvent(Tetrahedron tetrahedron) {
        register.replace(tetrahedron.getTetrahedronId(), calculateParameters(tetrahedron));
        LOG.info("Changed tetrahedron's parameters with id={} on {}", tetrahedron.getTetrahedronId(), calculateParameters(tetrahedron));
    }

    public void addTetrahedron(Tetrahedron tetrahedron) {
        register.put(tetrahedron.getTetrahedronId(), calculateParameters(tetrahedron));
        LOG.info("Add tetrahedron to register {}", tetrahedron);

    }

    private List<Double> calculateParameters(ShapeTetrahedron tetrahedron) {

        List<Double> parameters = new ArrayList<>();
        SurfaceAreaTetrahedron surfaceAreaTetrahedron = new SurfaceAreaTetrahedron();
        Double surfaceArea = surfaceAreaTetrahedron.calculateSurfaceAreaTetrahedron((Tetrahedron)tetrahedron);

        VolumeTetrahedron volumeTetrahedron = new VolumeTetrahedron();
        Double volume = volumeTetrahedron.calculateVolumeTetrahedron((Tetrahedron)tetrahedron);

        parameters.add(surfaceArea);
        parameters.add(volume);
        LOG.info("Calculate surface area and volume {}", parameters);

        return parameters;
    }

    public Map<Integer, List<Double>> getRegister() {
        return register;
    }
}
