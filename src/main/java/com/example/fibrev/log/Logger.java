package com.example.fibrev.log;

import com.example.fibrev.repository.DataRepository;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private final static Path pathLog = Paths.get("./src/main/resources/static/logs.txt");
    private static DataRepository dataRepository = new DataRepository();
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static void notification(String notification){
        Date date = new Date();
        dataRepository.writeRow(dateFormat.format(date) + " " + notification, pathLog);
    }
}
