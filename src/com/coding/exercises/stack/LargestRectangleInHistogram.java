package com.coding.exercises.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> runningHeightIndex = new Stack<Integer>();
        int maxArea = 0;
        for (int index = 0; index <= heights.length; index++) {
            int currentHeight = (index == heights.length) ? -1 : heights[index];
            while (!runningHeightIndex.isEmpty() && 
                   heights[runningHeightIndex.peek()] >= currentHeight) {
                
                int height = heights[runningHeightIndex.pop()];
                int width = runningHeightIndex.isEmpty() ? index : index - runningHeightIndex.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            
            } 
            runningHeightIndex.push(index);
        }
        return maxArea;
    }
}
