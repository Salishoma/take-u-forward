package com.oma.arrays;

public class UniquePath {
    public static int countUniquePart(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (i >= m || j >= n) {
            return 0;
        }
        return countUniquePart(i + 1, j, m, n) + countUniquePart(i, j + 1, m, n);
    }

    public static void main(String[] args) {
        System.out.println(countUniquePart(0, 0, 3, 3));
    }
}
