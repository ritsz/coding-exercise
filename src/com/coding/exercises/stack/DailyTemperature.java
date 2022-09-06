package com.coding.exercises.stack;

import java.util.Stack;

public class DailyTemperature {

    private class TemperatureDays {
        private Integer temperature;
        private Integer index;

        public Integer getTemperature() {
            return temperature;
        }

        public void setTemperature(Integer temperature) {
            this.temperature = temperature;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<TemperatureDays> temperatureStack = new Stack<>();

        int[] arr = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            TemperatureDays temperatureDays = new TemperatureDays();
            temperatureDays.setTemperature(temperatures[i]);
            temperatureDays.setIndex(i);

            // If this is higher than top temperatures, remove them since this will be the "WALL" from now.
            while(!temperatureStack.isEmpty() &&
                  temperatureDays.getTemperature() > temperatureStack.peek().getTemperature()) {
                temperatureStack.pop();
            }
            // The current top element has the next temperature that is more than current temperature.

            Integer maxLastTempDuration = 0;
            if (!temperatureStack.isEmpty()) {
                maxLastTempDuration = temperatureStack.peek().getIndex() - temperatureDays.getIndex();
            }
            arr[i] = maxLastTempDuration;

            temperatureStack.push(temperatureDays);
        }
        return arr;
    }
}
