package com.oma.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class KnapSack {

    private static class Pair {
        int weight;
        int value;

        public Pair(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static double maximumValue(Pair[] item, int n, int w) {
        Arrays.sort(item, new SortComparator());
        double maxValue = 0;
        int weight = w;
        for (Pair pair : item) {
            if (weight > pair.weight) {
                maxValue += pair.value;
                weight -= pair.weight;
            } else {
                maxValue += ((double) weight / (double) pair.weight) * pair.value;
                break;
            }
        }
        return maxValue;
    }

    public static class SortComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair p1, Pair p2) {
            double r1 = (double) p1.value / (double) p1.weight;
            double r2 = (double) p2.value / (double) p2.weight;
            if (r1 < r2) {
                return 1;
            } else if (r1 > r2) {
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(maximumValue(new Pair[]
                {new Pair(20, 100), new Pair(10, 60), new Pair(30, 120)}, 3, 50));
    }
}
