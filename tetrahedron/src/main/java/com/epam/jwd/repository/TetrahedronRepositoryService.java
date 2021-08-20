package com.epam.jwd.repository;

import com.epam.jwd.action.LengthsSidesTetrahedron;
import com.epam.jwd.action.SurfaceAreaTetrahedron;
import com.epam.jwd.action.VolumeTetrahedron;
import com.epam.jwd.entity.Tetrahedron;
import com.epam.jwd.exception.TetrahedronException;
import com.epam.jwd.register.Observable;
import com.epam.jwd.register.Observer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TetrahedronRepositoryService implements Observable<Tetrahedron>, Repository<Tetrahedron>, ParametersShape<Double>, Specifications<Tetrahedron> {

    private static final Logger LOG = LogManager.getLogger(CreatorDotsFromFile.class.getName());

    private List<Tetrahedron> tetrahedrons;
    private List<Observer> registers = new ArrayList<>();

    public TetrahedronRepositoryService() {
        this.tetrahedrons = new ArrayList<>();
    }

    @Override
    public List<Double> getAllVolume() {

        List<Double> volumes = new ArrayList<>();

        for (Tetrahedron tetrahedron: tetrahedrons) {
            VolumeTetrahedron volumeTetrahedron = new VolumeTetrahedron();
            double volume = volumeTetrahedron.calculateVolumeTetrahedron(tetrahedron);
            volumes.add(volume);
        }
        LOG.info("Tetrahedron's volumes {}", volumes);
        return volumes;
    }

    @Override
    public List<Double> getAllSurfaceArea() {

        List<Double> surfaceAreas = new ArrayList<>();

        for (Tetrahedron tetrahedron: tetrahedrons) {
            SurfaceAreaTetrahedron surfaceAreaTetrahedron = new SurfaceAreaTetrahedron();
            double surfaceArea = surfaceAreaTetrahedron.calculateSurfaceAreaTetrahedron(tetrahedron);
            surfaceAreas.add(surfaceArea);
        }
        LOG.info("Tetrahedron's surfaceAreas {}", surfaceAreas);
        return surfaceAreas;
    }

    @Override
    public List<Double> getAllPerimeters() {
        List<Double> perimeters = new ArrayList<>();
        LengthsSidesTetrahedron lengthsSidesTetrahedron = new LengthsSidesTetrahedron();

        for (Tetrahedron tetrahedron: tetrahedrons) {

            Map<String, Double> lengthSides = lengthsSidesTetrahedron.calculateLengthsSidesTetrahedron(tetrahedron);

            Double perimeter = lengthSides.get("a") + lengthSides.get("b") + lengthSides.get("c")
                    + lengthSides.get("d") + lengthSides.get("e") + lengthSides.get("h");
            perimeters.add(perimeter);
        }
        LOG.info("Tetrahedron's perimeters {}", perimeters);
        return perimeters;
    }

    @Override
    public void create(Tetrahedron tetrahedron) {
        tetrahedrons.add(tetrahedron);
    }

    @Override
    public Tetrahedron read(int index) {
        return tetrahedrons.get(index);
    }

    @Override
    public void update(int index, Tetrahedron tetrahedron) {
        tetrahedrons.set(index, tetrahedron);
        notifyRegisters(tetrahedron);
    }

    @Override
    public void delete(int index) {
        tetrahedrons.remove(index);
    }

    @Override
    public Tetrahedron getById(int id) throws TetrahedronException {

        Tetrahedron tetrahedronById = null;

        for (Tetrahedron tetrahedron: tetrahedrons) {
            if (id == tetrahedron.getTetrahedronId())
            tetrahedronById = tetrahedron;
        }
        if (tetrahedronById == null){
            throw new TetrahedronException("Repository have not contains tetrahedron with given id");
        }
        LOG.info("Tetrahedron with id = {} - {}", id, tetrahedronById);

        return tetrahedronById;
    }

    @Override
    public List<Tetrahedron> getByVolumeRange(Double minVolume, Double maxVolume) {

        for (Tetrahedron tetrahedron: tetrahedrons) {

            VolumeTetrahedron volumeTetrahedron = new VolumeTetrahedron();
            double volume = volumeTetrahedron.calculateVolumeTetrahedron(tetrahedron);
            if (volume <= minVolume && volume >= maxVolume) {
                tetrahedrons.remove(tetrahedron);
            }
        }
        LOG.info("Tetrahedrons in the range from {} to {}: ", minVolume,maxVolume, tetrahedrons);

        return tetrahedrons;
    }

    @Override
    public List<Tetrahedron> getByRangeFromPositiveOriginCoordinate(Double coordinatesOriginPositive) {

        for (Tetrahedron tetrahedron: tetrahedrons) {

            if (tetrahedron.getVertexDots().get(0).getX() < 0 && tetrahedron.getVertexDots().get(0).getY() < 0 &&
                    tetrahedron.getVertexDots().get(0).getZ() < 0 && tetrahedron.getVertexDots().get(1).getX() < 0 &&
                    tetrahedron.getVertexDots().get(1).getY() < 0 && tetrahedron.getVertexDots().get(1).getZ() < 0 &&
                    tetrahedron.getVertexDots().get(2).getX() < 0 && tetrahedron.getVertexDots().get(2).getY() < 0 &&
                    tetrahedron.getVertexDots().get(2).getZ() < 0 && tetrahedron.getVertexDots().get(3).getX() < 0 &&
                    tetrahedron.getVertexDots().get(3).getY() < 0 && tetrahedron.getVertexDots().get(3).getZ() < 0 &&
                    tetrahedron.getVertexDots().get(0).getX() > coordinatesOriginPositive &&
                    tetrahedron.getVertexDots().get(0).getY() > coordinatesOriginPositive &&
                    tetrahedron.getVertexDots().get(0).getZ() > coordinatesOriginPositive &&
                    tetrahedron.getVertexDots().get(1).getX() > coordinatesOriginPositive &&
                    tetrahedron.getVertexDots().get(1).getY() > coordinatesOriginPositive &&
                    tetrahedron.getVertexDots().get(1).getZ() > coordinatesOriginPositive &&
                    tetrahedron.getVertexDots().get(2).getX() > coordinatesOriginPositive &&
                    tetrahedron.getVertexDots().get(2).getY() > coordinatesOriginPositive &&
                    tetrahedron.getVertexDots().get(2).getZ() > coordinatesOriginPositive &&
                    tetrahedron.getVertexDots().get(3).getX() > coordinatesOriginPositive &&
                    tetrahedron.getVertexDots().get(3).getY() > coordinatesOriginPositive &&
                    tetrahedron.getVertexDots().get(3).getZ() > coordinatesOriginPositive) {
                tetrahedrons.remove(tetrahedron);
            }
        }
        LOG.info("Tetrahedron in the range from origin to {}(x,y,z): ", coordinatesOriginPositive, tetrahedrons);

        return tetrahedrons;
    }

    @Override
    public List<Tetrahedron> getSortById() {
        tetrahedrons.sort(Comparator.comparing(Tetrahedron::getTetrahedronId));
        LOG.info("List sorted tetrahedrons by id: {}", tetrahedrons);

        return tetrahedrons;
    }

    @Override
    public List<Tetrahedron> getSortByXCoordinateFirstDot() {
        tetrahedrons.sort(Comparator.comparingDouble(tetrahedron -> tetrahedron.getVertexDots().get(1).getX()));
        LOG.info("List sorted tetrahedrons by coordinates plane X first dot : {}", tetrahedrons);

        return tetrahedrons;
    }

    @Override
    public List<Tetrahedron> getSortByYCoordinateFirstDot() {
        tetrahedrons.sort(Comparator.comparingDouble(tetrahedron -> tetrahedron.getVertexDots().get(1).getY()));
        LOG.info("List sorted tetrahedrons by coordinates plane Y first dot : {}", tetrahedrons);

        return tetrahedrons;
    }

    @Override
    public void addRegister(Observer observer) {
        registers.add(observer);
    }

    @Override
    public void removeRegister(Observer observer) {
        registers.remove(observer);
    }

    @Override
    public void notifyRegisters(Tetrahedron tetrahedron) {
        for (Observer register : registers) {
            register.handleEvent(tetrahedron);
        }
    }
}
