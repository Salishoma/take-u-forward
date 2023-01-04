package com.oma.arrays;

public class StockTrade {
    public static int maximizeProfit(int[] arr) {
        int minPrice = arr[0];
        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            minPrice = Math.min(arr[i], minPrice);
            maxProfit = Math.max(arr[i] - minPrice, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maximizeProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maximizeProfit(new int[]{7,6,4,3,1}));
    }
}
