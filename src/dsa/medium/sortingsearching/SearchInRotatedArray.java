package dsa.medium.sortingsearching;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        SearchInRotatedArray obj = new SearchInRotatedArray();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 2;
        System.out.println(String.format("%d is found in array at index = %d", target, obj.search(nums, target)));
    }

    private int search(int[] nums, int target) {
            int length = nums.length;
            int low = 0;
            int high = length-1;

            while (low <= high) {

                int mid = (low + high) /2;
                if (nums[mid] == target) {
                    return mid;
                }

                //if first half is sorted
                if (nums[low] <= nums[mid]) {
                    if (target>=nums[low] && target<=nums[mid]) {
                        high = mid-1;
                    } else {
                        low = mid+1;
                    }
                } else { //second half should be sorted
                    if (target>=nums[mid] && target <= nums[high]) {
                        low = mid+1;
                    } else {
                        high = mid-1;
                    }
                }
            }

            return -1;
    }
}
