package dsa.medium.sortingsearching;

public class PeakElement {

    //multiple peak elements possible
    public static void main(String[] args) {
        PeakElement obj = new PeakElement();
        int[] nums = {1,2,1,3,5,6,4};
        int index = obj.findPeakElement(nums);
        System.out.println(String.format("Peak Element in O(N) => Index = %d ; Element = %d", index, nums[index]));

        index = obj.findPeakElementOptimised(nums);
        System.out.println(String.format("Peak Element in O(logN) => Index = %d ; Element = %d", index, nums[index]));
    }

    //O(n)
    private int findPeakElement(int[] nums) {
        int index = -1;
        int length = nums.length;
        if (length == 1) return 0;

        for (int i = 0; i < length; i++) {
            if ( (i == 0 || nums[i] > nums[i-1]) && (i == length-1 || nums[i] > nums[i+1]) ) {
                index = i;
                break;
            }
        }
        return index;
    }

    //O(logn)
    private int findPeakElementOptimised(int[] nums) {
        int length = nums.length;
        if (length == 1) return 0;

        int low = 0;
        int high = length-1;

        while (low <= high) {
            int mid = (low + high)/2;

            if ((mid == 0 || nums[mid] > nums[mid-1]) &&
                    (mid == length-1 || nums[mid] > nums[mid+1]) ) {
                return mid;
            }

            if (mid != 0 && nums[mid-1] > nums[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return -1;
    }

}
