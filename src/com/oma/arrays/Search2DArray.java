package com.oma.arrays;

public class Search2DArray {

    public static boolean search(int[][] matrix, int target) {
        int f = 0;
        int l = matrix.length - 1;
        int mid = (f + l) / 2;
        int j = matrix[0].length - 1;
        int piv = -1;
        while (f <= l) {
            if (matrix[mid][0] < target && matrix[mid][j] < target) {
                f = mid + 1;
            } else if (matrix[mid][0] <= target && matrix[mid][j] >= target) {
                piv = mid;
                break;
            } else if (matrix[mid][0] > target) {
                l = mid - 1;
            }
            mid = (f + l) / 2;
        }
        if (piv == -1) {
            return false;
        }
        f = 0;
        l = matrix[0].length - 1;
        mid = (f + l) / 2;
        while (f <= l) {
            if (matrix[piv][mid] == target) {
                return true;
            }
            if (matrix[piv][mid] < target) {
                f = mid + 1;
            } else {
                l = mid - 1;
            }
            mid = (f + l) / 2;
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(search(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 3));
//        System.out.println(search(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 13));
//        System.out.println(search(new int[][]{{1}, {3}}, 1));
        System.out.println(search(new int[][]{{1, 3, 5}}, 3));
    }
}
