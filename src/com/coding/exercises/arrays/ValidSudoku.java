package com.coding.exercises.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, HashSet<Character>> columns = new HashMap();
        Map<Integer, HashSet<Character>> rows = new HashMap();
        Map<String, HashSet<Character>> squares = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char data = board[i][j];
                if (data == '.') continue;

                String key = String.valueOf(i/3) + String.valueOf(j/3);

                rows.computeIfAbsent(i, k -> new HashSet<>());
                columns.computeIfAbsent(j, k -> new HashSet<>());
                squares.computeIfAbsent(key, k -> new HashSet<>());

                if (columns.get(j).contains(data)) {
                    // System.out.println("Column " + j + " has duplicate data: " + data);
                    return false;
                }

                if (rows.get(i).contains(data)) {
                    // System.out.println("Row " + i + " has duplicate data: " + data);
                    return false;
                }

                if (squares.containsKey(key) && squares.get(key).contains(data)) {
                    // System.out.println("Square " + key + " has duplicate data: " + data);
                    return false;
                }

                columns.get(j).add(data);
                rows.get(i).add(data);
                squares.get(key).add(data);
            }
        }
        return true;
    }
}
