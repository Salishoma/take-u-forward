package com.oma.strings;

public class CommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs[0].length() == 0) {
            return "";
        }
        int j = 0;
        String str = strs[0];
        String pref = "";
        String res = "";
        while (j < str.length()) {
            pref += str.charAt(j);
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].startsWith(pref)) {
                    return res;
                }
            }
            res = pref;
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"flower","flow","flight"});
    }
}
