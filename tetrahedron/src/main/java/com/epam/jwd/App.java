package com.epam.jwd;

import com.epam.jwd.additional.CreatorDotsFromFile;
import com.epam.jwd.additional.CreatorTetrahedron;
import com.epam.jwd.entity.Dot;
import com.epam.jwd.entity.Tetrahedron;
import com.epam.jwd.register.ChangerCoordinatesTetrahedron;
import com.epam.jwd.register.RegisterTetrahedron;
import com.epam.jwd.repository.Repository;
import com.epam.jwd.repository.TetrahedronRepository;


import java.io.IOException;
import java.util.List;

public class App {

    public static void main( String[] args ) throws IOException {

        CreatorDotsFromFile creatorDotsFromFile = new CreatorDotsFromFile();

        List a = creatorDotsFromFile.createDotsFromFile();


        List dot = creatorDotsFromFile.getDotsForTetrahedrons();
        System.out.println(dot.toString());

        CreatorTetrahedron creatorTetrahedron = new CreatorTetrahedron(creatorDotsFromFile);
        TetrahedronRepository.getTetrahedronRepository().sortById();

        System.out.println(RegisterTetrahedron.getRegisterTetrahedron().getRegister());

        ChangerCoordinatesTetrahedron changerCoordinatesTetrahedron = new ChangerCoordinatesTetrahedron();
        changerCoordinatesTetrahedron.addRegister(RegisterTetrahedron.getRegisterTetrahedron());
        changerCoordinatesTetrahedron.changeCoordinatesTetrahedronInRepository(2,
                3, new Dot(2, 10, -10));
        System.out.println(RegisterTetrahedron.getRegisterTetrahedron().getRegister());


    }
}
