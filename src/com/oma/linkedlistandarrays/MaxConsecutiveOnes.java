package com.oma.linkedlistandarrays;

public class MaxConsecutiveOnes {
    public static int countMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 1) {
                count += 1;
            } else {
                count = 0;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countMaxConsecutiveOnes(new int[]{1,0,0,1,1,1,0,1,1,0,0,1}));
    }
}
