package com.example.fibrev.service;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    public ArrayList<String> getReversedFibonacciRows(ArrayList<String> allRows){
        ArrayList<String> reversedFibonacciRows = new ArrayList<>();
        for(String row : allRows){
            if(isRowFibonacci(row)){
                reversedFibonacciRows.add(reversedFibonacci(row));
            }
        }
        return reversedFibonacciRows;
    }

    private boolean isRowFibonacci(String row){
        String[] splitRow = row.split(",");
        if(splitRow.length == 0){
            return false;
        }
        int value;
        List<Integer> values = new ArrayList<>();
        for(String temp : splitRow){
            if(temp == null || temp.equals("")){
                return false;
            }
            try {
                value = Integer.parseInt(temp);
                values.add(value);
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return isFibonacciSequence(values);
    }

    private boolean isFibonacciSequence(List<Integer> values){
        if(values.size() < 3){
            return true;
        }
        for(int i = 3; i < values.size(); i++){
            if(!(values.get(i - 1) + values.get(i - 2) == values.get(i))){
                return false;
            }
        }
        return true;
    }

    private String reversedFibonacci(String row){
        String reversedRow = "";
        char temp;
        for(int i = 0; i < row.length(); i++){
            temp = row.charAt(i);
            reversedRow = temp + reversedRow;
        }
        return reversedRow;
    }

    public String toStringRows(ArrayList<String> rows){
        StringBuilder allRows = new StringBuilder();
        for (String row : rows){
            allRows.append(row).append("\n");
        }
        return allRows.toString();
    }
}
