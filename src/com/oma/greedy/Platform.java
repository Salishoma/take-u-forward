//package com.oma.greedy;
//
//import java.util.*;
//
//public class Platform {
//
//    public static class Train {
//        int startTime;
//        int endTime;
//
//        public Train(int startTime, int endTime) {
//            this.startTime = startTime;
//            this.endTime = endTime;
//        }
//    }
//
//    public static class SortTrain implements Comparator<Train> {
//
//        @Override
//        public int compare(Train t1, Train t2) {
//            if (t1.endTime < t2.endTime) {
//                return -1;
//            } else if (t1.endTime > t2.endTime) {
//                return 1;
//            }
//            return 0;
//        }
//    }
//
//    public static int calculateMinPatforms(int n, int[] arr, int[] dep) {
//        Train[] trains = new Train[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            trains[i] = new Train(arr[i], dep[i]);
//        }
//        Arrays.sort(trains, new SortTrain());
//
//        int max = 1;
//        int end = dep[0];
//        int numTrains = 1;
//
//        for (int i = 1; i < trains.length; i++) {
//            if (end < trains[i].startTime) {
//                numTrains = 1;
//            } else {
//                numTrains += 1;
//            }
//            end = trains[i].endTime;
//            max = Math.max(numTrains, max);
//        }
//
//        return max;
//    }
//
//    public static void main(String[] args) {
////        System.out.println(calculateMinPatforms(6, new int[]{900, 940, 950, 1100, 1500, 1800}, new int[]{910, 1200, 1120, 1130, 1900, 2000}));
////        System.out.println(calculateMinPatforms(2, new int[]{900, 1000}, new int[]{999, 1100}));
//        System.out.println(calculateMinPatforms(4, new int[]{100, 200, 300, 400}, new int[]{200, 300, 400, 500}));
////        System.out.println(calculateMinPatforms(3, new int[]{1200, 1300, 1450}, new int[]{1310, 1440, 1600}));
//    }
//}


package com.oma.greedy;

        import java.util.*;

public class Platform {

    public static class Train {
        int startTime;
        int endTime;

        public Train(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static class SortTrain implements Comparator<Train> {

        @Override
        public int compare(Train t1, Train t2) {
            if (t1.endTime < t2.endTime) {
                return -1;
            } else if (t1.endTime > t2.endTime) {
                return 1;
            }
            return 0;
        }
    }

    public static int calculateMinPatforms(int n, int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int count = 1;

        int i = 1;
        int j = 0;
        int ans = 1;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                count += 1;
                i++;
            } else {
                count -= 1;
                j++;
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(calculateMinPatforms(6, new int[]{900, 940, 950, 1100, 1500, 1800}, new int[]{910, 1200, 1120, 1130, 1900, 2000}));
        System.out.println(calculateMinPatforms(2, new int[]{900, 1000}, new int[]{999, 1100}));
        System.out.println(calculateMinPatforms(4, new int[]{100, 200, 300, 400}, new int[]{200, 300, 400, 500}));
        System.out.println(calculateMinPatforms(3, new int[]{1200, 1300, 1450}, new int[]{1310, 1440, 1600}));
        System.out.println(calculateMinPatforms(3, new int[]{41, 1616, 297, 2042, 1013, 987, 2050, 525, 636, 109},
                new int[]{2275, 2076, 1580, 2144, 1231, 1672, 2137, 1016, 2234, 1043 }));
    }
}
