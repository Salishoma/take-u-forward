package com.oma.strings;

public class CountAndSay {
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String res = "1";
        for (int i = 2; i <= n; i++) {
            int j = 1;
            StringBuilder temp = new StringBuilder();
            char prev = res.charAt(0);
            int count = 1;
            while (j < res.length()) {
                if (prev == res.charAt(j)) {
                    count += 1;
                } else {
                    temp.append(count).append(prev);
                    count = 1;
                }
                prev = res.charAt(j);
                j += 1;
            }
            res = temp.toString() + count + "" + prev;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(CountAndSay.countAndSay(6));
    }
}
