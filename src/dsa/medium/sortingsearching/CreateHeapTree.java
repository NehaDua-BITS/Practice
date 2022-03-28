package dsa.medium.sortingsearching;

import java.util.Arrays;

public class CreateHeapTree {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        CreateHeapTree obj = new CreateHeapTree();

        System.out.println("Heap tree = " + Arrays.toString(obj.createHeapTree(nums)));
    }

    //minHeap
    private int[] createHeapTree(int[] nums) {
        int length = nums.length;
        int[] heapArr = new int[length];
        int index  = 0;

        //insert elements
        for (int i = 0; i < length; i++) {
            heapArr[index]= nums[i];
            heapify(heapArr, index);
            index++;
        }

        return heapArr;
    }

    private void heapify(int[] heapArr, int index) {

      while (index != 0) {
          int parent = (index - 1) / 2;
          if (heapArr[parent] <= heapArr[index]) {
              break;
          }
          int temp = heapArr[parent];
          heapArr[parent] = heapArr[index];
          heapArr[index] = temp;
          index = parent;
      }
    }

}
