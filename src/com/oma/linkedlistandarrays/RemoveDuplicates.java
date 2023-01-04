package com.oma.linkedlistandarrays;

import java.util.Arrays;

public class RemoveDuplicates {

    public static int[] RemoveDuplicatesFromArray(int[] nums) {
        int ind = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (num != nums[i]) {
                nums[ind++] = nums[i];
                num = nums[i];
            }
        }
        return nums;
//        int ind = 1;
//        int num = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == num) {
//                nums[i] = 0;
//            } else {
//                nums[ind] = nums[i];
//                num = nums[i];
//                if (i != ind) {
//                    nums[i] = 0;
//                }
//                ind += 1;
//            }
//        }
//        return nums;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(RemoveDuplicatesFromArray(new int[]{1, 2, 2, 2, 2, 3, 3})));
        System.out.println(Arrays.toString(RemoveDuplicatesFromArray(new int[]{1,1,1,2,2,3,3,3,3,4,4})));
    }
}
