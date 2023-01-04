package com.oma.strings;

import java.util.HashMap;

public class RomanNumerals {
    public static int romanToInt(String str) {
        HashMap<Character, Integer> romanNumerals = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int ind = str.length() - 1;
        Character prev = str.charAt(ind);
        int res = romanNumerals.get(prev);
        for (int i = ind - 1; i >= 0; i--) {
            Character cur = str.charAt(i);
            if (romanNumerals.get(cur) < romanNumerals.get(prev)) {
                res -= romanNumerals.get(cur);
            } else {
                res += romanNumerals.get(cur);
            }
            prev = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("III"));
    }
}
