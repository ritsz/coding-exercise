package com.coding.exercises.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.coding.exercises.sorting.quicksort.QuickSort;
import com.coding.exercises.sorting.quicksort.QuickSortTest;

public class SolutionRunner {

    private static List<Integer> integerList = new ArrayList<>();
    private static String string = new String();

    private static void acceptIntegers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers, with -1 to end");

        while (true) {
            int input = scanner.nextInt();
            if (input == -1) {
                break;
            }
            integerList.add(input);
        }
        System.out.println("You entered: " + integerList);
    }

    private static void acceptString() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            string = bufferedReader.readLine();
            bufferedReader.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }

    }

    public static void main(String[] args) {
    }
}