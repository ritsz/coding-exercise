package com.coding.exercises.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {

    public ContainsDuplicate() {
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!uniqueNumbers.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if (i > k) {
                uniqueNumbers.remove(nums[i-k-1]);
            }
            if (!uniqueNumbers.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    private long getID(long i, long w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }

//    Sliding Window 2 Bucket size 5
//    Number 1 bucket 0
//    Adding 1 to bucket 0
//
//    Number 17 bucket 2
//    Adding 17 to bucket
//
//    Number 25 bucket 4
//    Adding 25 to bucket 4
//
//    Removed 1 from bucket 0
//
//    Number 5 bucket 0
//    Adding 5 to bucket 0
//
//    Removed 17 from bucket 2
//
//    Number 9 bucket 1
//    PREV Bucket present. And matches 9 in NEXT bucket
//    Bucket Data 5
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;

        /*
         * At anytime, each bucket will have atmost 1 value,
         * because if they had 2, those 2 would have been the answer.
         *
         * If a number doesn't have any number in it's bucket, it should be compared
         * to PREV and NEXT bucket numbers to calculate the distance and compare to t.
         *
         * Numbers outside the window k should be removed from it's bucket.
         */
        System.out.println("Sliding Window " + k + " Bucket size " + t);
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            System.out.println("Number " + nums[i] + " bucket " + m);
            if (d.containsKey(m)) {
                System.out.println("Bucket " + m + " present.");
                return true;
            }
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
            {
                System.out.println("PREV Bucket present. And matches " + nums[i] + " in NEXT bucket");
                System.out.println("Bucket Data " + d.get(m - 1));
                return true;
            }
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
            {
                System.out.println("NEXT Bucket present. And matches " + nums[i] + " in PREV bucket");
                System.out.println("Bucket Data " + d.get(m + 1));
                return true;
            }
            System.out.println("Adding " + nums[i] + " to bucket " + m);
            d.put(m, (long)nums[i]);
            if (i >= k) {
                long id = getID(nums[i - k], w);
                d.remove(id);
                System.out.println("Removed " + nums[i-k] + " from bucket " + id);
            }
        }
        return false;
    }
}