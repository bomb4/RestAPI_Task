package com.example.fibrev.controller;

import com.example.fibrev.entity.DataEntity;
import com.example.fibrev.log.Logger;
import com.example.fibrev.repository.DataRepository;
import com.example.fibrev.service.DataService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/data")
public class DataController {

    @GetMapping
    public  DataEntity add(@RequestParam(value = "row") String row) {
        new DataRepository().writeRow(row, DataRepository.pathIn);
        Logger.notification("Entered new row");
        return new DataEntity(row);
    }

    @GetMapping("/fibo")
    public String reversing(){
        DataRepository dataRepository = new DataRepository();
        DataService dataService = new DataService();

        ArrayList<String> rows = dataRepository.readRows();
        ArrayList<String> reversedFibonacciRows = dataService.getReversedFibonacciRows(rows);
        String generalString = dataService.toStringRows(reversedFibonacciRows);

        dataRepository.writeReversedRows(generalString);

        return generalString;
    }
}
