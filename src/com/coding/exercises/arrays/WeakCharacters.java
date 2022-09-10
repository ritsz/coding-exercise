package com.coding.exercises.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class WeakCharacters {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] != o1[0]) {
                    return Integer.compare(o2[0], o1[0]);
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            }
        });

        int max = 0, count = 0;
        for (int i = 0; i < properties.length; i++) {

            if (properties[i][1] < max) {
                count++;
            }
            max = Math.max(max, properties[i][1]);
        }

        return count;
    }
}
