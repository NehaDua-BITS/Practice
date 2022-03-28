package dsa.easy.trees;

public class SortedArrayToBST {
    public static void main(String[] args) {

        SortedArrayToBST obj = new SortedArrayToBST();

        int[] nums = {-10,-3,0,5,9};
        TreeNode root = obj.sortedArrayToBST(nums);
        System.out.println("Balance BST is : ");
        root.printPreorder();
    }

    private TreeNode sortedArrayToBST(int[] nums) {

        return arrayToBSTUtil(nums, 0, nums.length-1);
    }

    private TreeNode arrayToBSTUtil(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrayToBSTUtil(nums, start, mid-1);
        root.right = arrayToBSTUtil(nums, mid+1, end);
        return root;
    }

}
