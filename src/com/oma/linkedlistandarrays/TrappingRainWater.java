package com.oma.linkedlistandarrays;

public class TrappingRainWater {
    public static int getTotalWaterTrapped(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;

        while (left < right){
           if (arr[left] < arr[right]) {
               if (arr[left] >= leftMax) {
                   leftMax = arr[left];
               } else {
                   ans += (leftMax - arr[left]);
               }
               left += 1;
           } else {
               if (arr[right] >= rightMax) {
                   rightMax = arr[right];
               } else {
                   ans += (rightMax - arr[right]);
               }
               right -= 1;
           }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(getTotalWaterTrapped(new int[]{0,1,0,2,1,0,1,3,2,1,2,1,2}));
//        System.out.println(getTotalWaterTrapped(new int[]{4,2,0,3,2,5}));
        System.out.println(getTotalWaterTrapped(new int[]{5,4,1,2}));
    }
}
