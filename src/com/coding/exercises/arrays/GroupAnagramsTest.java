package com.coding.exercises.arrays;

import org.junit.jupiter.api.Test;

public class GroupAnagramsTest {

    private final GroupAnagrams groupAnagrams;

    public GroupAnagramsTest() {
        groupAnagrams = new GroupAnagrams();
    }

    @Test
    public void testWithAnagrams() {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams.groupAnagrams(strs);
    }

    @Test
    public void testWithEmptyList() {
        String[] strs = {};
        groupAnagrams.groupAnagrams(strs);
    }
}
