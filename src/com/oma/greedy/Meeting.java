package com.oma.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Meeting {

    public static List<Integer> maxMeeting(int[] start, int[] end) {
        List<Meet> meets = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            Meet meet = new Meet();
            meet.start = start[i];
            meet.end = end[i];
            meet.pos = i;
            meets.add(meet);
        }

        MeetComparator mc = new MeetComparator();
        meets.sort(mc);
        int limit = meets.get(0).end;

        List<Integer> res = new ArrayList<>();
        res.add(meets.get(0).pos + 1);

        for (Meet meet : meets) {
            if (limit < meet.start) {
                limit = meet.end;
                res.add(meet.pos + 1);
            }
        }
        return res;
    }

    static class Meet {
        int start;
        int end;
        int pos;
    }

    static class MeetComparator implements Comparator<Meet> {

        @Override
        public int compare(Meet m1, Meet m2) {
            if (m1.end < m2.end) {
                return -1;
            }
            if (m1.end > m2.end) {
                return 1;
            }
            if (m1.pos < m2.pos) {
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(maxMeeting(new int[]{1, 3, 0, 5, 8, 5}, new int[]{2, 4, 6, 7, 9, 9}));
        System.out.println(maxMeeting(new int[]{1, 1, 1}, new int[]{4, 5, 9}));
        System.out.println(maxMeeting(new int[]{0, 7, 1, 4, 8}, new int[]{2, 9, 5, 9, 10}));
        System.out.println(maxMeeting(new int[]{1, 2, 3}, new int[]{4 ,4, 4}));
    }
}
