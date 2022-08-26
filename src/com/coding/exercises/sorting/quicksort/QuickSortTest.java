package com.coding.exercises.sorting.quicksort;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuickSortTest {
    private final QuickSort quickSort;

    public QuickSortTest() {
        quickSort = new QuickSort();
    }

    private boolean isArrayIncreasing(List<Integer> array) {
        for (int i=0; i < array.size()-1; i++) {
            if (array.get(i) > array.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void TestSimple() {
        List<Integer> simple = Arrays.asList(10, 16, 8, 12, 15, 6, 3, 9, 25);
        System.out.println(simple);
        quickSort.sort(simple);
        System.out.println("---------- RESULT OF TEST TestSimple ----------");
        System.out.println(simple);
        assertTrue(isArrayIncreasing(simple));
        System.out.println("------------------------------------");
        System.out.println("");
    }

    @Test
    public void TestSmallestElementAtLast() {
        List<Integer> simple = Arrays.asList(10, 16, 8, 12, 15, 6, 99, 9, 3);
        System.out.println(simple);
        quickSort.sort(simple);
        System.out.println("---------- RESULT OF TEST TestSmallestElementAtLast ----------");
        System.out.println(simple);
        assertTrue(isArrayIncreasing(simple));
        System.out.println("------------------------------------");
        System.out.println("");
    }

    @Test
    public void LargestElementFirst() {
        List<Integer> simple = Arrays.asList(100, 16, 8, 12, 15, 6, 99, 9, 3);
        System.out.println(simple);
        quickSort.sort(simple);
        System.out.println("---------- RESULT OF TEST LargestElementFirst ----------");
        System.out.println(simple);
        assertTrue(isArrayIncreasing(simple));
        System.out.println("------------------------------------");
        System.out.println("");
    }

    @Test
    public void TestEmptyList() {
        List<Integer> simple = Arrays.asList();
        System.out.println(simple);
        quickSort.sort(simple);
        System.out.println("---------- RESULT OF TEST TestEmptyList ----------");
        System.out.println(simple);
        assertTrue(isArrayIncreasing(simple));
        System.out.println("------------------------------------");
        System.out.println("");
    }

    @Test
    public void TestSortedList() {
        List<Integer> simple = Arrays.asList(3, 6, 8, 9, 10, 12, 15, 16, 99);
        System.out.println(simple);
        quickSort.sort(simple);
        System.out.println("---------- RESULT OF TEST TestSortedList ----------");
        System.out.println(simple);
        assertTrue(isArrayIncreasing(simple));
        System.out.println("------------------------------------");
        System.out.println("");
    }

    @Test
    public void TestDescendingList() {
        List<Integer> simple = Arrays.asList(99, 87, 12, 10, 3, 0);
        System.out.println(simple);
        quickSort.sort(simple);
        System.out.println("---------- RESULT OF TEST TestDescendingList ----------");
        System.out.println(simple);
        assertTrue(isArrayIncreasing(simple));
        System.out.println("------------------------------------");
        System.out.println("");
    }

    @Test
    public void TestNegativeList() {
        List<Integer> simple = Arrays.asList(-10, -16, -8, -12, -15, -6, -99, -9, -3);
        System.out.println(simple);
        quickSort.sort(simple);
        System.out.println("---------- RESULT OF TEST TestNegativeList ----------");
        System.out.println(simple);
        assertTrue(isArrayIncreasing(simple));
        System.out.println("------------------------------------");
        System.out.println("");
    }

    @Test
    public void TestMixedList() {
        List<Integer> simple = Arrays.asList(-10, 16, -8, -12, 15, -6, -99, 9, -3);
        System.out.println(simple);
        quickSort.sort(simple);
        System.out.println("---------- RESULT OF TEST TestMixedList ----------");
        System.out.println(simple);
        assertTrue(isArrayIncreasing(simple));
        System.out.println("------------------------------------");
        System.out.println("");
    }

    @Test
    public void TestDuplicatesList() {
        List<Integer> simple = Arrays.asList(10, 7, 5, 5, 4, 7, 1);
        System.out.println(simple);
        quickSort.sort(simple);
        System.out.println("---------- RESULT OF TEST TestDuplicatesList ----------");
        System.out.println(simple);
        assertTrue(isArrayIncreasing(simple));
        System.out.println("------------------------------------");
        System.out.println("");
    }

    @Test
    public void TestHugeList() {
        List<Integer> simple = Arrays.asList(-10, 16, -8, -12, 15, -6, -99, 9, -3,
                                             -87, 22, 9, 83, -100, 32, 279, 250, 92,
                                             -64, 5, 106, 282, 242, 296, -22, 194, 38,
                                             251, 104, 265, -55, 16, 228, 86, 239, -61,
                                             -84, -95, 222, 249, 79, -56, 248, 59, 292);
        System.out.println(simple);
        quickSort.sort(simple);
        System.out.println("---------- RESULT OF TEST TestHugeList ----------");
        System.out.println(simple);
        assertTrue(isArrayIncreasing(simple));
        System.out.println("------------------------------------");
        System.out.println("");
    }
}
