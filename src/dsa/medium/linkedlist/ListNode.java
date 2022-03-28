package dsa.medium.linkedlist;

public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      public void printList() {
            ListNode sumHead = this;
            while (sumHead != null) {
                  System.out.println(sumHead.val + " ");
                  sumHead = sumHead.next;
            }
      }

}

