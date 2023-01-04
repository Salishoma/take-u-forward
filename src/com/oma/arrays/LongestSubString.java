package com.oma.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    public static int lengthOfLongestSubString(String str) {
        String longestStr = longestSubstringWithoutDuplication(str);
        return longestStr.length();
    }

    public static String longestSubstringWithoutDuplication(String str) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int prev = 0;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            Character s = str.charAt(i);
            if (!map.containsKey(s)) {
                if (max <= i - prev + 1) {
                    start = prev;
                    max = i - prev + 1;
                }
            } else {
                int num = prev > map.get(s) ? prev - 1 : map.get(s);
                max = Math.max(max, i - num);
                prev = num + 1;
            }
            map.put(s, i);

        }
        return str.substring(start, start + max);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubString("abcabcbb"));
        System.out.println(lengthOfLongestSubString("decadevsindecagonarelit"));
        System.out.println(lengthOfLongestSubString("abcaabcdba"));
        System.out.println(lengthOfLongestSubString("bbbbb"));
        System.out.println(lengthOfLongestSubString("pwwkew"));
        System.out.println(lengthOfLongestSubString("tmmzuxt"));
        System.out.println(lengthOfLongestSubString("aabaab!bb"));
    }
}
