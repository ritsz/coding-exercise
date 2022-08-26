package com.coding.exercises.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContainsDuplicateTest {

    private final ContainsDuplicate containsDuplicate;

    public ContainsDuplicateTest() {
        containsDuplicate = new ContainsDuplicate();
    }

    @Test
    public void testEmptyList() {
        int[] nums = {};
        boolean value = containsDuplicate.containsDuplicate(nums);
        Assertions.assertFalse(value);
    }

    @Test
    public void testSingleEntry() {
        int[] nums = {1};
        boolean value = containsDuplicate.containsDuplicate(nums);
        Assertions.assertFalse(value);
    }

    @Test
    public void testNoDuplicates() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        boolean value = containsDuplicate.containsDuplicate(nums);
        Assertions.assertFalse(value);
    }

    @Test
    public void testNoDuplicatesWithNegatives() {
        int[] nums = {1, -2, 3, -4, 5, -6, 7};
        boolean value = containsDuplicate.containsDuplicate(nums);
        Assertions.assertFalse(value);
    }

    @Test
    public void testDuplicates() {
        int[] nums = {1, 2, 3, 4, 1};
        boolean value = containsDuplicate.containsDuplicate(nums);
        Assertions.assertTrue(value);
    }

    @Test
    public void testDuplicatesWithNegatives() {
        int[] nums = {-1, -1, -1, -1, 1, 1, 1, 1};
        boolean value = containsDuplicate.containsDuplicate(nums);
        Assertions.assertTrue(value);
    }

    @Test
    public void testNearbyDuplicateEmptyList() {
        int[] nums = {};
        boolean value = containsDuplicate.containsNearbyDuplicate(nums, 10);
        Assertions.assertFalse(value);
    }

    @Test
    public void testNearbyDuplicateSingleElement() {
        int[] nums = {1};
        boolean value = containsDuplicate.containsNearbyDuplicate(nums, 10);
        Assertions.assertFalse(value);
    }

    @Test
    public void testNearbyDuplicateSingleElementZeroDistance() {
        int[] nums = {1};
        boolean value = containsDuplicate.containsNearbyDuplicate(nums, 0);
        Assertions.assertFalse(value);
    }

    @Test
    public void testNearbyDuplicateNoDuplicates() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        boolean value = containsDuplicate.containsNearbyDuplicate(nums, nums.length);
        Assertions.assertFalse(value);
    }

    @Test
    public void testNearbyDuplicaetWithDuplicatesAtExtreme() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 1};
        boolean value = containsDuplicate.containsNearbyDuplicate(nums, nums.length);
        Assertions.assertTrue(value);
    }

    @Test
    public void testNearbyDuplicateWithDuplicatesFarAway() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 1};
        boolean value = containsDuplicate.containsNearbyDuplicate(nums, 2);
        Assertions.assertFalse(value);
    }

    @Test
    public void testNearbyDuplicateWithDuplicatesExactDistance() {
        int[] nums = {1, 0, 1, 1};
        boolean value = containsDuplicate.containsNearbyDuplicate(nums, 1);
        Assertions.assertTrue(value);
    }

    @Test
    public void testNearbyDuplicateWithDuplicateJustMissing() {
        int[] nums = {1, 0, 1, 0, 1, 0};
        boolean value = containsDuplicate.containsNearbyDuplicate(nums, 1);
        Assertions.assertFalse(value);
    }

    @Test
    public void testNearbyAlmostDuplicateEmptyList() {
        int[] nums = {};
        boolean value = containsDuplicate.containsNearbyAlmostDuplicate(nums, 1, 1);
        Assertions.assertFalse(value);
    }

    @Test
    public void testNearbyAlmostDuplicateWithDuplicate() {
        int[] nums = {1,2,3,1};
        boolean value = containsDuplicate.containsNearbyAlmostDuplicate(nums, 3, 0);
        Assertions.assertTrue(value);
    }

    @Test
    public void testNearbyAlmostDuplicateWithDuplicateFarAway() {
        int[] nums = {1,2,3,4,5,1};
        boolean value = containsDuplicate.containsNearbyAlmostDuplicate(nums, 3, 0);
        Assertions.assertFalse(value);
    }

    @Test
    public void testNearbyAlmostDuplicateWithAlmostDuplicate() {
        int[] nums = {1,0,1,1};
        boolean value = containsDuplicate.containsNearbyAlmostDuplicate(nums, 1, 1);
        Assertions.assertTrue(value);
    }

    @Test
    public void testNearbyAlmostDuplicateWithNoDuplicate() {
        int[] nums = {1,5,9,1,5,9};
        boolean value = containsDuplicate.containsNearbyAlmostDuplicate(nums, 2, 3);
        Assertions.assertFalse(value);
    }

    @Test
    public void testNearbyAlmostDuplicateWithExtremeData() {
        int[] nums = {-2147483648, 2147483647};
        boolean value = containsDuplicate.containsNearbyAlmostDuplicate(nums, 1, 1);
        Assertions.assertFalse(value);
    }

    @Test
    public void testNearbyAlmostDuplicateDataAcrossNextBucket() {
        int[] nums = {1, 9, 17, 5};
        boolean value = containsDuplicate.containsNearbyAlmostDuplicate(nums, 2, 5);
        Assertions.assertTrue(value);
    }

    @Test
    public void testNearbyAlmostDuplicateDataAcrossPrevBucket() {
        int[] nums = {5, 17, 9};
        boolean value = containsDuplicate.containsNearbyAlmostDuplicate(nums, 2, 5);
        Assertions.assertTrue(value);
    }
}
