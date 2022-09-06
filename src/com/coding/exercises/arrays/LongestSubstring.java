package com.coding.exercises.arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LongestSubstring {
    public LongestSubstring() {
    }

    public int lengthOfLongestSubstring(String s) {
        List<Character> runningList = new LinkedList<>();
        int maxSubstringLength = 0;
        
        for(Character c : s.toCharArray()) {
            System.out.println("Char : " + c);
            if (!runningList.contains(c)) {
                runningList.add(c);
                maxSubstringLength = Math.max(maxSubstringLength, runningList.size());
                System.out.println("Running List : " + runningList);
                System.out.println("Max Length : " + maxSubstringLength);
            } else {
                int index = runningList.indexOf(c);
                System.out.println("Cleanup till : " + index);
                while(index >= 0) {
                    runningList.remove(0);
                    index--;
                }
                runningList.add(c);
                System.out.println("Running List : " + runningList);
            }
        }
        return maxSubstringLength;
    }

    public int lengthOfLongestSubstringAnswer(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
