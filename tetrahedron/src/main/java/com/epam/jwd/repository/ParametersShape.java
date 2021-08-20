package com.epam.jwd.repository;

import java.util.List;

public interface ParametersShape<T> {

    List<T> getAllVolume();
    List<T> getAllSurfaceArea();
    List<T> getAllPerimeters();
}
