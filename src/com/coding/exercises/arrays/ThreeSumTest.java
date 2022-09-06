package com.coding.exercises.arrays;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThreeSumTest {
    private final ThreeSum threeSum;

    public ThreeSumTest() {
        threeSum = new ThreeSum();
    }

    @Test
    public void testZeroList() {
        int[] nums = {0, 0, 0};
        List<List<Integer>> result = threeSum.threeSum(nums);
        Assertions.assertTrue(result.size() == 1);
    }

    @Test
    public void testNoAnswer() {
        int[] nums = {1, 0, 1};
        List<List<Integer>> result = threeSum.threeSum(nums);
        Assertions.assertTrue(result.size() == 0);
    }

    @Test
    public void testOneAnswer() {
        int[] nums = {-1, 0, 1};
        List<List<Integer>> result = threeSum.threeSum(nums);
        Assertions.assertTrue(result.size() == 1);
    }

    @Test
    public void testTwoAnswer() {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum.threeSum(nums);
        Assertions.assertTrue(result.size() == 2);
    }

}
