package com.epam.jwd.additional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderFileWithDots {

    private static final Logger LOG = LogManager.getLogger(CreatorDotsFromFile.class.getName());
    File file = new File("data/info.txt");

    public List toReadFileWithDots() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = bufferedReader.readLine()) != null){
                lines.add(line);
                stringBuilder.append(line).append("\n");
            }
        } catch(FileNotFoundException e){
            LOG.error("File for read not found!");
        }

        return lines;
    }
}
