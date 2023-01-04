package com.oma.strings;

public class Reverse {
    public static String reverseWord(String str) {
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == 32) {
                if (res.length() != 0 && (i + 1) < str.length() && str.charAt(i + 1) != 32) {
                    res.append(" ");
                }
                res.append(temp);
                temp = new StringBuilder();
            } else {
                temp.insert(0, str.charAt(i));
            }
        }
        if (!temp.toString().equals("")) {
            res.append(" ").append(temp);
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
//        System.out.println(reverseWord("this is an amazing program"));
        System.out.println(reverseWord("a good   example"));
//        System.out.println(reverseWord("  hello world  "));
    }
}
