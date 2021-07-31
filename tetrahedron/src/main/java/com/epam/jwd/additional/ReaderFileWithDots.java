package com.epam.jwd.additional;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderFileWithDots {

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
            e.printStackTrace();
        }

        return lines;
    }
}
