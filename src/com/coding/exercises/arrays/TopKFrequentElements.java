package com.coding.exercises.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public TopKFrequentElements() {
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Arrays.stream(nums).forEach(num -> {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        });
        System.out.println("Frequency Map: " + frequencyMap);

        List<Integer>[] buckets = new List[nums.length+1];
        for(Integer num: frequencyMap.keySet()) {
            Integer frequency = frequencyMap.get(num);
            if (buckets[frequency] == null) {
                buckets[frequency] = new LinkedList<>();
            }
            buckets[frequency].add(num);
        }

        System.out.println("Buckets: " + buckets);

        int result[] = new int[k];
        for(int i=buckets.length-1, index = 0; i>0 && k>0; --i){
            if(buckets[i]!=null){
                List<Integer> list = buckets[i];
                for(Integer data: list) {
                    result[index] = data;
                    index = index + 1;
                }
                k-= list.size();
            }
        }
        return result;
    }
}
