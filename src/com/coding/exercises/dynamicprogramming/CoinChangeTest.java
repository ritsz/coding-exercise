package com.coding.exercises.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoinChangeTest {

    private CoinChange coinChange;

    public CoinChangeTest() {
        this.coinChange = new CoinChange();
    }

    @Test
    public void testSimple() {
        int[] coins = {1,2,5};
        int target = 11;
        int result = coinChange.coinChange(coins, target);
        Assertions.assertTrue(result  == 3);
    }

    @Test
    public void testNotPossible() {
        int[] coins = {5};
        int target = 1;
        int result = coinChange.coinChange(coins, target);
        Assertions.assertTrue(result == -1);
    }

    @Test
    public void testNotPossible2() {
        int[] coins = {2};
        int target = 3;
        int result = coinChange.coinChange(coins, target);
        Assertions.assertTrue(result == -1);
    }

    @Test
    public void testLarge() {
        int[] coins = {1,2,3,4,5};
        int target = 45;
        int result = coinChange.coinChange(coins, target);
        Assertions.assertTrue(result == 9);
    }

    @Test
    public void testBigNumbers() {
        int[] coins = {186,419,83,408};
        int target = 6249;
        int result = coinChange.coinChange(coins, target);
        Assertions.assertTrue(result == 20);
    }

    @Test
    public void testSmallNumbersLargeTarget() {
        int[] coins = {1,2,5};
        int target = 100;
        int result = coinChange.coinChange(coins, target);
        Assertions.assertTrue(result == 20);
    }
}
