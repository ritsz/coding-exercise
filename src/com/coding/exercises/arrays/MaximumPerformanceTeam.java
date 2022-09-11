package com.coding.exercises.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumPerformanceTeam {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] employeeStats = new int[n][2];
        for (int index = 0; index < n; index++) {
            employeeStats[index][0] = speed[index];
            employeeStats[index][1] = efficiency[index];
        }
        Arrays.sort(employeeStats, (a, b) -> Integer.compare(b[1], a[1]));

        Queue<Integer> minSpeed = new PriorityQueue<>();
        long totalSpeed = 0, result = 0;
        for (int[] stat: employeeStats) {
            if (minSpeed.size() == k) {
                totalSpeed -= minSpeed.poll();
            }
            int leastEfficiency = stat[1];  // The efficiency is sorted in DEC order. This is the least leastefficiency yet.
            int currentSpeed = stat[0];
            totalSpeed += currentSpeed;
            minSpeed.add(currentSpeed);
            result = Math.max(result, totalSpeed * leastEfficiency);
        }
        return (int) (result % (long)(1e9 + 7));
    }
}
