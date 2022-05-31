package dsa.microsoft.strings;

public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates  obj = new RemoveDuplicates();
        int[] nums = {2, 3, 3, 3, 6, 9, 9};

        int result =  obj.removeDuplicates(nums);
        System.out.println("New length after duplicates removal = " + result);
        System.out.println("Unique elements in array are :");
        for (int i = 0; i < result; i++) {
            System.out.println(nums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int lastUniqueNumIndex = -1;
        for (int currentIndex = 0; currentIndex < n; currentIndex++) {
            if (lastUniqueNumIndex == -1 || nums[lastUniqueNumIndex] != nums[currentIndex]) {
                nums[++lastUniqueNumIndex] = nums[currentIndex];
            }
        }

        return lastUniqueNumIndex+1;
    }
}
