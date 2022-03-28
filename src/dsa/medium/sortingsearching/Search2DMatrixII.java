package dsa.medium.sortingsearching;

public class Search2DMatrixII {

    public static void main(String[] args) {
        //int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        //int target = 20;
//        int target = 5;
//        int[][] matrix = {{1}, {3}, {5}};
        int[][] matrix = {
                {3,6,9,12,17,22},
                {5,11,11,16,22,26},
                {10,11,14,16,24,31},
                {10,15,17,17,29,31},
                {14,17,20,23,34,37},
                {19,21,22,28,37,40},
                {22,22,24,32,37,43}};

        int target = 20;

        boolean result = new Search2DMatrixII().searchMatrix(matrix, target);
        System.out.println(target + " is found in the matrix = " + result);

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int lastCol = -1;

        for (int i = 0; i < rows; i++) {
            int begin = 0;
            int end = cols-1;

            if (i != 0) {
                if (target >= matrix[i][lastCol]) {
                    begin = lastCol;
                } else {
                    end = lastCol;
                }
            }
            lastCol = binarySearch(matrix[i], target, begin, end);
            if (lastCol == -1) {
                break;
            }
            if (matrix[i][lastCol] == target) {
                return true;
            }
        }

        return false;
    }

    private int binarySearch(int[] arr, int target, int start, int end) {

        int low = start;
        int high = end;

        while (low <= high) {
            int mid = (low+high)/2;
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                if (mid+1 == arr.length || target < arr[mid+1]) {
                    return mid;
                } else {
                    low = mid+1;
                }
            } else if (target < arr[mid]) {
                high = mid - 1;
            }
        }

        return -1;
    }

}
