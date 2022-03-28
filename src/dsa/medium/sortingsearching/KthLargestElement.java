package dsa.medium.sortingsearching;

public class KthLargestElement {
    public static void main(String[] args) {
        KthLargestElement obj = new KthLargestElement();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int result = obj.findKthLargest(nums, k);
        System.out.println("Kth largest element = " + result);
    }

    //using max heap
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;

        //build max heap with first k elements
        Heap heap = new Heap(nums, k);

        //process remaining n-k elements using min heap
        for (int i = k; i < length; i++) {
            if (heap.getMin() < nums[i]) {
                heap.replaceRoot(nums[i]);
            }
        }

        return heap.getMin();
    }

    class Heap {
        int[] heapArr;
        int currSize;

        Heap(int[] arr, int k) {
            heapArr = arr;
            currSize = k;

            for (int i = (currSize-1)/2; i >= 0; i--) {
                minHeapify(i);
            }
        }

        public void replaceRoot(int n) {
            heapArr[0] = n;
            minHeapify(0);
        }

        public int getMin() {
            if (currSize == 0) return Integer.MIN_VALUE;

            return heapArr[0];
        }
        //max heap
        private void minHeapify(int index) {
            int l = 2*index + 1;
            int r = 2*index + 2;
            int smallest = index;
            if (l < currSize && heapArr[l] < heapArr[index]) {
                smallest = l;
            }

            if (r < currSize && heapArr[r] < heapArr[smallest]) {
                smallest = r;
            }

            if (smallest != index) {
                int temp = heapArr[smallest];
                heapArr[smallest] = heapArr[index];
                heapArr[index] = temp;
                minHeapify(smallest);
            }
        }
    }

}
