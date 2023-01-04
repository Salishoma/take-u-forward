package com.oma.greedy;

import java.util.Arrays;


public class JobSequence {

    public static int[] JobScheduling(int[][] jobs) {
        Arrays.sort(jobs, (entry1, entry2) -> entry2[1] - entry1[1]);
        int max = 0;

        for (int i = 0; i < jobs.length; i++) {
            if (max < jobs[i][0]) {
                max = jobs[i][0];
            }
        }

        boolean[] filled = new boolean[max + 1];

        int sum = 0;
        int count = 0;

        for (int[] job : jobs) {

            for (int j = job[0]; j > 0; j--) {
                if (!filled[j]) {
                    count += 1;
                    filled[j] = true;
                    sum += job[1];
                    break;
                }
            }
        }

        return new int[]{count, sum};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(JobSequence
                .JobScheduling(new int[][]{{4, 30},{4,10},{4,20},{1,10},{1,40},{1,30}})));

        System.out.println(Arrays.toString(JobSequence
                .JobScheduling(new int[][]{{4,20},{1,10},{1,40},{1,30}})));

    }

}
