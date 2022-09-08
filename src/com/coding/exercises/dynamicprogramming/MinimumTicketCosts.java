package com.coding.exercises.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumTicketCosts {
    private Map<Integer, Integer> minCostMap = new HashMap<>();
    public int mincostTickets(int[] days, int[] costs) {
        return minCostSoFar(days, costs);
    }

    private int minCostSoFar(int[] days, int[] costs) {
        if (days.length == 0) {
            return 0;
        }

        if (days.length == 1) {
            return Math.min(costs[2], Math.min(costs[1], costs[0]));  // For a single day, buy a single day ticket.
        }

        if (minCostMap.containsKey(days[0]))
            return minCostMap.get(days[0]);

        int OneDayCost = costs[0];
        int SevenDayCost = costs[1];
        int ThirtyDayCost = costs[2];

        int todaysDate = days[0];
        int SevenDayIndex = -1, ThirtyDayIndex = -1;
        for (int index = 1; index < days.length; index++) {
            if (days[index] - todaysDate > 6 && SevenDayIndex == -1)   // Days are inclusive of the day the ticket was bought.
                SevenDayIndex = index;

            if (days[index] - todaysDate > 29 && ThirtyDayIndex == -1) {
                ThirtyDayIndex = index;
                break;
            }
        }

        OneDayCost += minCostSoFar(Arrays.copyOfRange(days, 1, days.length), costs);
        if (SevenDayIndex != -1) {
            System.out.println("Today: "  + todaysDate + " : 7 days from Today will NOT Include: " + days[SevenDayIndex]);
            SevenDayCost += minCostSoFar(Arrays.copyOfRange(days, SevenDayIndex, days.length), costs);
        }
        if (ThirtyDayIndex != -1) {
            System.out.println("Today: "  + todaysDate + " : 30 days from Todaywill NOT Include: " + days[ThirtyDayIndex]);
            ThirtyDayCost += minCostSoFar(Arrays.copyOfRange(days, ThirtyDayIndex, days.length), costs);
        }

        System.out.println("Today: " + todaysDate + " : 1 Day ticket Cost " + OneDayCost + " : 7 Day ticket Cost " + SevenDayCost + " : 30 Day ticket Cost " + ThirtyDayCost);
        int minCost = Math.min(ThirtyDayCost, Math.min(SevenDayCost, OneDayCost));
        minCostMap.put(todaysDate, minCost);
        return minCost;
    }
}
