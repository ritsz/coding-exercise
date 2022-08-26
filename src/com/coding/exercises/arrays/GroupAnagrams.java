package com.coding.exercises.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> anagramGroup = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char tempStr[] = strs[i].toCharArray();
            System.out.println("String: " + strs[i]);
            Arrays.sort(tempStr);
            String sortedStr = new String(tempStr);
            System.out.println("Sorted String: " + sortedStr);
            if (anagramGroup.containsKey(sortedStr)) {
                List<String> currentList = anagramGroup.get(sortedStr);
                String data = strs[i];
                currentList.add(data);
                anagramGroup.put(sortedStr, currentList);
                System.out.println("Anagram List: " + anagramGroup.get(sortedStr));
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                anagramGroup.put(sortedStr, newList);
                System.out.println("Anagram List: " + anagramGroup.get(sortedStr));
            }
        }

        for(List<String> anagrams: anagramGroup.values()) {
            result.add(anagrams);
        }
        return result;
    }
}
