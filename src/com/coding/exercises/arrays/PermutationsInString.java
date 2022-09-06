package com.coding.exercises.arrays;

import java.util.HashMap;
import java.util.Map;

public class PermutationsInString {
    
    private boolean isEmpty(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int[] arr = new int[26];

        int i = 0;
        int j = 0;
        for(; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        for(; j < s1.length(); j++) {
            int index = s2.charAt(j) - 'a';
            arr[index]--;
        }
        if (isEmpty(arr)) return true;
        i = 0;
        while(j < s2.length()) {
            arr[s2.charAt(j) - 'a']--;
            arr[s2.charAt(i) - 'a']++;
            if (isEmpty(arr)) return true;
            i++;
            j++;
        }
        return false;
    }

}
