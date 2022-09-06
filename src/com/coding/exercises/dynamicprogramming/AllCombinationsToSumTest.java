package com.coding.exercises.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AllCombinationsToSumTest {

    private AllCombinationsToSum allCombinationsToSum;

    public AllCombinationsToSumTest() {
        this.allCombinationsToSum = new AllCombinationsToSum();
    }

    @Test
    public void testSimple() {
        int[] nums = {1};
        int target = 1;
        int count = allCombinationsToSum.solution(nums, target);
        Assertions.assertTrue(count==1);
    }

    @Test
    public void testNotPossible() {
        int[] nums = {3};
        int target = 1;
        int count = allCombinationsToSum.solution(nums, target);
        Assertions.assertTrue(count==0);
    }

    @Test
    public void testRegularCase() {
        int[] nums = {1,2,3};
        int target = 4;
        int count = allCombinationsToSum.solution(nums, target);
        Assertions.assertTrue(count==7);
    }


    @Test
    public void testLargeCase() {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int target = 45;
        int count = allCombinationsToSum.solution(nums, target);
        Assertions.assertTrue(count==1357836297);
    }
}
