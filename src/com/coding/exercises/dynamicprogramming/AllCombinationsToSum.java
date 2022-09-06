package com.coding.exercises.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class AllCombinationsToSum {

    private Map<Integer, Integer> memoize = new HashMap<>();

    public int solution(int[] nums, int target) {
        if (memoize.containsKey(target))
            return memoize.get(target);

        if (target == 0) {
            return 1;
        }

        if (target < 0) {
            return -1;
        }

        int count = 0;
        for (int index = 0; index < nums.length; index++) {
            // If the nums[index] is selected, the new target is target - nums[index];
            // What are the ways to solve this newTarget?
            int newTarget = target - nums[index];
            if (newTarget < 0) continue;

            count += solution(nums, newTarget);
        }
        memoize.put(target, count);
        return count;
    }

}
