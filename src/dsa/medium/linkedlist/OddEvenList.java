package dsa.medium.linkedlist;

public class OddEvenList {

    public static void main(String[] args) {
        OddEvenList obj = new OddEvenList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode head = obj.oddEvenList(l1);
        head.printList();
    }

    public ListNode oddEvenList(ListNode head) {
        //handling if 0, 1 or 2 nodes
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode evenHead = null;
        ListNode evenTail = null;
        int index = 1;
        while (head != null) {
            if (index % 2 != 0) { //odd node
                if (oddTail != null) {
                    oddTail.next = head;
                } else {
                    oddHead = head;
                }
                oddTail = head;
            } else { //even index
                if (evenTail != null) {
                    evenTail.next = head;
                } else {
                    evenHead = head;
                }
                evenTail = head;
            }
            head = head.next;
            index++;
        }

        oddTail.next = evenHead;
        evenTail.next = null;

        return oddHead;
    }
}
