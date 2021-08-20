package com.epam.jwd.repository;

import com.epam.jwd.exception.TetrahedronException;

import java.util.List;

public interface Specifications<T> {

    T getById(int id) throws TetrahedronException;

    List<T> getByVolumeRange(Double minVolume, Double maxVolume);
    List<T> getByRangeFromPositiveOriginCoordinate(Double coordinatesOriginPositive);
    List<T> getSortById();
    List<T> getSortByXCoordinateFirstDot();
    List<T> getSortByYCoordinateFirstDot();
}
