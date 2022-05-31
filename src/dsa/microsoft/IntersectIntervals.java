package dsa.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectIntervals {

    public static void main(String[] args) {
        int[][] arr1 = {
                {1, 3},
                {5, 7},
                {9, 12}
        };
        int[][] arr2 = {
                {5, 10}
        };

        List<List<Integer>> result = new IntersectIntervals().intersect(arr1, arr2);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(Arrays.toString(result.get(i).toArray()));
        }
    }

    private List<List<Integer>> intersect(int[][] arr1, int[][] arr2) {
        List<List<Integer>> resultList = new ArrayList<>();
        int count1 = arr1.length;
        int count2 = arr2.length;

        int i = 0;
        int j = 0;
        while (i < count1 && j < count2) {
            if ( (arr1[i][0] >= arr2[j][0] && arr1[i][0] <= arr2[j][1]) || (arr2[j][0] >= arr1[i][0] && arr2[j][0] <= arr1[i][1]) ) {
                List<Integer> list = new ArrayList<>();
                list.add(Math.max(arr1[i][0], arr2[j][0]));
                list.add(Math.min(arr1[i][1], arr2[j][1]));
                resultList.add(list);
            }

            if (arr1[i][1] < arr2[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return resultList;
    }

}
