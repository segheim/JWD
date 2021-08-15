package com.epam.jwd.additional;

import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;
import com.epam.jwd.register.RegisterTetrahedron;
import com.epam.jwd.repository.TetrahedronRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CreatorTetrahedron {

    private static final Logger LOG = LogManager.getLogger(CreatorDotsFromFile.class.getName());

    List<Tetrahedron> tetrahedrons = new ArrayList<>();

    public CreatorTetrahedron(CreatorDotsFromFile creatorDotsFromFile) {

        List dotsForTetrahedron = creatorDotsFromFile.getDotsForTetrahedrons();

        for (Object dot : dotsForTetrahedron) {
            Tetrahedron tetrahedron = new Tetrahedron((List<Dot>) dot);
            tetrahedrons.add(tetrahedron);
            TetrahedronRepository.getTetrahedronRepository().create(tetrahedron);
            RegisterTetrahedron.getRegisterTetrahedron().addTetrahedron(tetrahedron);
        }
        LOG.info("List tetrahedrons: {}", tetrahedrons);
    }

    public List<Tetrahedron> getTetrahedrons() {
        return tetrahedrons;
    }
}
