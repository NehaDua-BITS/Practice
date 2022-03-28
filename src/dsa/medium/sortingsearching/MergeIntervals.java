package dsa.medium.sortingsearching;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{2,6},{1,3},{15,18},{8,10}};
        int[][] result = new MergeIntervals().merge(intervals);
        System.out.println("Merged Intervals Array : ");
        for (int i = 0; i < result.length; i++)
            System.out.println(Arrays.toString(result[i]));
    }

    private int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        int length = intervals.length;

        //sort based on start time
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        System.out.println("Sorted intervals array : ");
        for (int i = 0; i < length; i++)
            System.out.println(Arrays.toString(intervals[i]));

        int count = length;
        //start with end element and do binary search to find merge interval
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length && intervals[i][0]!=-1; j++) {
                if (intervals[j][0] != -1 && (intervals[j][0] <= intervals[i][1])) {
                    intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                    intervals[j][0] = -1;
                    intervals[j][1] = -1;
                    count--;
                }
            }
        }

        int[][] result = new int[count][2];
        for(int i = 0, j = 0; i < length; i++) {
            if(intervals[i][0] != -1) {
                result[j][0] = intervals[i][0];
                result[j][1] = intervals[i][1];
                j++;
            }
        }

        return result;
    }

}
