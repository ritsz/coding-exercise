package com.coding.exercises.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WeakCharactersTest {

    private WeakCharacters weakCharacters;

    public WeakCharactersTest() {
        this.weakCharacters = new WeakCharacters();
    }

    @Test
    public void testSimple() {
        int[][] properties = {{5,5},{6,3},{3,6}, {3,5}};
        int ret = weakCharacters.numberOfWeakCharacters(properties);
        Assertions.assertTrue(ret==0);
    }

    @Test
    public void testSimpleOneWeek() {
        int[][] properties = {{1,5},{10,4},{4,3}};
        int ret = weakCharacters.numberOfWeakCharacters(properties);
        Assertions.assertTrue(ret==1);
    }

    @Test
    public void testBiggerList() {
        int[][] properties = {{7,7},{1,2},{9,7},{7,3},{3,10},{9,8},{8,10},{4,3},{1,5},{1,5}};
        int ret = weakCharacters.numberOfWeakCharacters(properties);
        Assertions.assertTrue(ret==6);
    }
}
