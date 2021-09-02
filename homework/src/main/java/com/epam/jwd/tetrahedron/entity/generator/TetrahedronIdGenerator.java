package com.epam.jwd.entity.generator;

public class TetrahedronIdGenerator {

    private static int count = 1;

    public static int generateId() {
        return count++;
    }
}
