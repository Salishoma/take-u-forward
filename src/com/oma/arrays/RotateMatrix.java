package com.oma.arrays;

import java.util.Arrays;

public class RotateMatrix {
    public static int[][] rotateMatrix(int[][] matrix) {
        int length = matrix.length;
        int breadth = matrix[0].length;
        int[][] res = new int[matrix.length][breadth];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < breadth; j++) {
                res[i][j] = matrix[length - j - 1][i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(rotateMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(Arrays.deepToString(
                rotateMatrix(new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}}))
        );
    }
}
