package com.oma.greedy;

public class Coin {

    public static int findMinimumCoins(int amount) {
        int[] coins = new int[]{1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int res = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount >= coins[i]) {
                int num = amount / coins[i];
                res += num;
                amount -= num * coins[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMinimumCoins(70));
    }
}
