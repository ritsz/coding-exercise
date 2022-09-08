package com.coding.exercises.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinimumTicketCostsTests {
    MinimumTicketCosts minimumTicketCosts;

    public MinimumTicketCostsTests() {
        this.minimumTicketCosts = new MinimumTicketCosts();
    }

    @Test
    public void testSimple() {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2, 7, 15};
        int ret = minimumTicketCosts.mincostTickets(days, costs);
        Assertions.assertTrue(ret == 11);
    }

    @Test
    public void testCheaperTickets() {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {7, 2, 15};
        int ret = minimumTicketCosts.mincostTickets(days, costs);
        Assertions.assertTrue(ret == 6);
    }

    @Test
    public void testTestOneMonth() {
        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2, 7, 15};
        int ret = minimumTicketCosts.mincostTickets(days, costs);
        Assertions.assertTrue(ret == 17);
    }
}
