package com.coding.exercises.sorting.quicksort;

import java.util.List;

import com.coding.exercises.utils.Printer;

public class QuickSort {


    public QuickSort() {
    }

    private void swap(List<Integer> array, int i, int j) {
        int tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }

    private int partition(List<Integer> array, int i, int j) {
        int pivot = i;
        Printer.debug("START : " + i + ", number : " + array.get(i));
        Printer.debug("END : " + j + ", number : " + array.get(j));
        Printer.debug("PIVOT : " + pivot + ", number : "+ array.get(pivot));

        while(i < j) {
            while (array.get(i) < array.get(pivot)) {
                i++;
            }
            Printer.debug("--- i: "+ i + " : " + array.get(i));
            while (array.get(j) > array.get(pivot)) {
                j = j-1;
            }
            Printer.debug("--- j: "+ j + " : " + array.get(j));

            if (i != j && array.get(i) == array.get(j)) {
                Printer.debug("--- Numbers at i and j are same. NO SWAP : " + array.get(i) + " : " + array.get(j));
                i++;
                j--;
                Printer.debug("--- Numbers at NEW i and j : " + array.get(i) + " : " + array.get(j));
            }

            if (i < j) {
                swap(array, i, j);
                Printer.debug("--- arr: " + array);
            }
        }
        swap(array, j, pivot);
        Printer.debug("Partitioned: " + array + " at index " + j);
        Printer.debug();
        return j;
    }

    private void sort(List<Integer> array, int i, int j) {
        if (i < j) {
            int p = partition(array, i, j);
            sort(array, i, p);
            sort(array, p+1, j);
            Printer.debug("Array: " + array);
            Printer.debug();
            Printer.debug();
        }
    }

    public void sort(List<Integer> array) {
        sort(array, 0, array.size()-1);
    }

}
