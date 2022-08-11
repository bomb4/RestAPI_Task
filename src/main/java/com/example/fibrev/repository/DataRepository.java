package com.example.fibrev.repository;

import com.example.fibrev.entity.DataEntity;
import com.example.fibrev.log.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataRepository {
    public final static Path pathIn = Paths.get("./src/main/resources/static/rows.txt");
    public final static Path pathRev = Paths.get("./src/main/resources/static/reversed_rows.txt");


    public void writeRow(String row, Path path){
        File file = new File(String.valueOf(path));
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
            fr.write(row + "\n");
        } catch (IOException ex) {
            Logger.notification(ex.getMessage());
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                Logger.notification(e.getMessage());
            }
        }
    }

    public ArrayList<String> readRows(){
        ArrayList<String> lines = new ArrayList<>();
        try (Stream<String> lineStream = Files.newBufferedReader(pathIn).lines()) {
            lines = (ArrayList<String>) lineStream.collect(Collectors.toList());
        } catch (IOException ignored) {
            Logger.notification(ignored.getMessage());
        }
        return lines;
    }
    public void writeReversedRows(String reversedRows){
        try {
            Files.writeString(pathRev, reversedRows, StandardCharsets.UTF_8);
            Logger.notification("New rows");
        } catch (IOException ex) {
            Logger.notification(ex.getMessage());
        }
    }
}
