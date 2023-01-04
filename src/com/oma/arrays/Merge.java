package com.oma.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Merge {
    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void mergeTwoSortedArrays(int[] arr1, int[] arr2, int m, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = i + j + 1;
        while (j >= 0) {
            if (i < 0) {
                arr1[k--] = arr2[j--];
            } else if (arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }
        }
        System.out.println(Arrays.toString(arr1));
    }

    public static void main(String[] args) {

        mergeTwoSortedArrays(new int[]{1,2,3,0,0,0},new int[]{2, 5, 6}, 3, 3);
        mergeTwoSortedArrays(new int[]{1,2,4,5,6,0},new int[]{3}, 5, 1);
        mergeTwoSortedArrays(new int[]{4,5,6,0,0,0},new int[]{1,2,3}, 3, 3);
        mergeTwoSortedArrays(new int[]{0,0,3,0,0,0,0,0,0},new int[]{-1,1,1,1,2,3}, 3, 6);
        mergeTwoSortedArrays(new int[]{-1,0,1,1,0,0,0,0,0},new int[]{-1,0,2,2,3}, 4, 5);
//        System.out.println(Arrays.deepToString(mergeIntervals(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
//        System.out.println(Arrays.deepToString(mergeIntervals(new int[][]{{1, 4}, {4, 15}})));
//        System.out.println(Arrays.deepToString(mergeIntervals(new int[][]{{1, 4}, {1, 4}})));
//        System.out.println(Arrays.deepToString(mergeIntervals(new int[][]{{4, 5}, {1, 4}, {0, 1}})));
//        System.out.println(Arrays.deepToString(
//                mergeIntervals(new int[][]{{4, 5}, {2, 4}, {4, 6}, {3, 4}, {0, 0}, {1, 1}, {3, 5}, {2, 2}})));
    }
}
