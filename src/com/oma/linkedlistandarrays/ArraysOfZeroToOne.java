package com.oma.linkedlistandarrays;

import java.util.Arrays;

public class ArraysOfZeroToOne {

    // Not yet correct
    public static int[] sortArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int countLeft = 1;
        int countRight = 1;
        while (left < right) {
            if (arr[left] == 0) {
                left += 1;
            }else if (arr[right] == 2) {
                right -= 1;
            }else if (arr[left] == 2) {
                if (arr[left] > arr[right]) {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
                right -= 1;
            }else if (arr[right] == 0) {
                if (arr[right] < arr[left]) {
                    int temp = arr[right];
                    arr[right] = arr[left];
                    arr[left] = temp;
                }
                left += 1;
            }else if (arr[left] == 1) {
                if (arr[left] > arr[left + countLeft]) {
                    int temp = arr[left];
                    arr[left] = arr[left + countLeft];
                    arr[left + countLeft] = temp;
                    left += 1;
                    countLeft = 1;
                } else {
                    countLeft += 1;
                    if (left + countLeft >= arr.length || right - countRight < 0) {
                        break;
                    }
//                    if (left + countLeft >= right - countRight) {
//                        break;
//                    }
                }
                countRight = 1;
            } else if (arr[right] == 1) {
                if (arr[right] < arr[right - countRight]) {
                    int temp = arr[right];
                    arr[right] = arr[right - countRight];
                    arr[right - countRight] = temp;
                    right -= 1;
                    countRight = 1;
                } else {
                    countRight += 1;
                    if (left + countLeft >= arr.length || right - countRight < 0) {
                        break;
                    }
                }
                countLeft = 1;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(sortArray(new int[]{2, 0, 2, 1, 1, 0})));
//        System.out.println(Arrays.toString(sortArray(new int[]{1, 0, 2, 0, 0, 1})));
        System.out.println(Arrays.toString(sortArray(new int[]{1,2,1})));
//        System.out.println(Arrays.toString(sortArray(new int[]{0, 1})));
    }
}
