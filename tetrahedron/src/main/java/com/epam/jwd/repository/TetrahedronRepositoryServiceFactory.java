package com.epam.jwd.repository;

public class TetrahedronRepositoryServiceFactory {

    private static TetrahedronRepositoryService tetrahedronService;

    private TetrahedronRepositoryServiceFactory() {
    }

    public static TetrahedronRepositoryService getTetrahedronRepositoryService() {
        if (tetrahedronService == null){
            tetrahedronService = new TetrahedronRepositoryService();
        }
        return tetrahedronService;
    }
}
