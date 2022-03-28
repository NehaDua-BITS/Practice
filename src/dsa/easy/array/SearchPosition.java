package dsa.easy.array;

public class SearchPosition {

    public static void main(String[] args) {
        SearchPosition obj = new SearchPosition();
        int[] nums = {1,3,5,6};
        int target = 7;
        int index = obj.searchInsert(nums, target);
        System.out.println("Insert Position = " + index);
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                if (mid == 0 || target > nums[mid-1]) {
                    return mid;
                }
                high = mid-1;
            } else {
                if (mid == nums.length-1 || (target < nums[mid+1])) {
                    return mid+1;
                }
                low = mid+1;
            }
        }

        return -1;
    }

}
