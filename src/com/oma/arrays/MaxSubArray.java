package com.oma.arrays;

import java.util.Arrays;

public class MaxSubArray {
    public static int maxSubArraySum(int[] arr) {
        int prev = 0;
        int size = 1;
        int max = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            if (sum > arr[i]) {
                if (sum > max) {
                    size = i - prev + 1;
                    max = sum;
                }
            } else {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (sum - arr[i] < 0) {
                    size = 1;
                    prev = i;
                    sum = arr[i];
                }
            }

        }
        int[] newArray = Arrays.copyOfRange(arr, prev, prev + size);
        System.out.println(Arrays.toString(newArray));
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArraySum(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArraySum(new int[]{1}));
        System.out.println(maxSubArraySum(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArraySum(new int[]{8,-19,5,-4,20}));
    }
}
