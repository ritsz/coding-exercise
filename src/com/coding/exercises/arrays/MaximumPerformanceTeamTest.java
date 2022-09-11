package com.coding.exercises.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumPerformanceTeamTest {
    private MaximumPerformanceTeam maximumPerformanceTeam;

    public MaximumPerformanceTeamTest() {
        maximumPerformanceTeam = new MaximumPerformanceTeam();
    }

    @Test
    public void testSimple() {
        int[] speed = {2,10,3,1,5,8};
        int[] efficiency = {5,4,3,9,7,2};
        int k = 2;
        int ret = maximumPerformanceTeam.maxPerformance(speed.length, speed, efficiency, k);
        Assertions.assertTrue(ret == 60);
    }

    @Test
    public void testSimple2() {
        int[] speed = {2,10,3,1,5,8};
        int[] efficiency = {5,4,3,9,7,2};
        int k = 3;
        int ret = maximumPerformanceTeam.maxPerformance(speed.length, speed, efficiency, k);
        Assertions.assertTrue(ret == 68);
    }

    @Test
    public void testSimple3() {
        int[] speed = {2,10,3,1,5,8};
        int[] efficiency = {5,4,3,9,7,2};
        int k = 4;
        int ret = maximumPerformanceTeam.maxPerformance(speed.length, speed, efficiency, k);
        Assertions.assertTrue(ret == 72);
    }
}
