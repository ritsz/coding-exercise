package com.coding.exercises.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        checkSumAndBacktrack(candidates, 0, target, new ArrayList<Integer>());
        return result;
    }
    
    private void checkSumAndBacktrack(int[] candidates, int startIndex, int remainingSum, List<Integer> runningList) {
        // Exceeded
        if (remainingSum < 0) return;

        // Match
        if (remainingSum == 0) {
            result.add(runningList);
            return;
        }

        // Iterate all options
        for(int index = startIndex; index < candidates.length; index++) {
            runningList.add(candidates[index]);
            checkSumAndBacktrack(candidates, index, remainingSum - candidates[index], runningList);
            runningList.remove(runningList.size() - 1);
        }
    }
}
