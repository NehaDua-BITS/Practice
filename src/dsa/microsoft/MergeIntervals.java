package dsa.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {
                {6,7}, {2,4}, {5,9}
        };
        int[][] result = new MergeIntervals().merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    private int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 1) {
            return intervals;
        }

        List<List<Integer>> result = new ArrayList<>();

        //sort intervals on the basis of start time
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int length = intervals.length;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            } else {
                result.add(getList(start, end));
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(getList(start, end));

        //convert arraylist to array
        int[][] mergedIntervals = new int[result.size()][2];
        for (int i = 0, j = 0; i < result.size(); i++, j++) {
            mergedIntervals[j][0] = result.get(i).get(0);
            mergedIntervals[j][1] = result.get(i).get(1);
        }

        return mergedIntervals;
    }

    private List<Integer> getList(int start, int end) {
        List<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(end);
        return list;
    }

}
