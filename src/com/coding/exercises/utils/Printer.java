package com.coding.exercises.utils;

import java.util.Map;

public class Printer {

    private static Map<String, String> env = System.getenv();

    public static void debug(String log) {
        if(env.containsKey("DEBUG")
           && env.get("DEBUG").equalsIgnoreCase("true")) {
            System.out.println(log);
        }
    }
    public static void debug() {
        if(env.containsKey("DEBUG")
           && env.get("DEBUG").equalsIgnoreCase("true")) {
            System.out.println("");
        }
    }
}
