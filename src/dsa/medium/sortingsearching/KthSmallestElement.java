package dsa.medium.sortingsearching;

public class KthSmallestElement {

    public static void main(String[] args) {
        KthSmallestElement obj = new KthSmallestElement();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int result = obj.findKthSmallest(nums, k);
        System.out.println("Kth smallest element = " + result);
    }

    //using max heap
    public int findKthSmallest(int[] nums, int k) {
        int length = nums.length;

        //build max heap with first k elements
        Heap heap = new Heap(nums, k);

        //process remaining n-k elements using min heap
        for (int i = k; i < length; i++) {
            if (heap.getMax() > nums[i]) {
                heap.replaceRoot(nums[i]);
            }
        }

        return heap.getMax();
    }

    class Heap {
        int[] heapArr;
        int currSize;

        Heap(int[] arr, int k) {
            heapArr = arr;
            currSize = k;

            for (int i = (currSize-1)/2; i >= 0; i--) {
                maxHeapify(i);
            }
        }

        public void replaceRoot(int n) {
            heapArr[0] = n;
            maxHeapify(0);
        }

        public int getMax() {
            if (currSize == 0) return Integer.MAX_VALUE;

            return heapArr[0];
        }
        //max heap
        private void maxHeapify(int index) {
            int l = 2*index + 1;
            int r = 2*index + 2;
            int largest = index;
            if (l < currSize && heapArr[l] > heapArr[index]) {
                largest = l;
            }

            if (r < currSize && heapArr[r] > heapArr[largest]) {
                largest = r;
            }

            if (largest != index) {
                int temp = heapArr[largest];
                heapArr[largest] = heapArr[index];
                heapArr[index] = temp;
                maxHeapify(largest);
            }
        }
    }

}
