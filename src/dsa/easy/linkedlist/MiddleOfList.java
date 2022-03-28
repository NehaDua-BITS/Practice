package dsa.easy.linkedlist;

public class MiddleOfList {

    public static void main(String[] args) {
        MiddleOfList obj = new MiddleOfList();
        ListNode head = ListNode.getSampleList(1);
        System.out.println("Original List : " + head);

        ListNode middle = obj.getMiddleElement(head);
        System.out.println("Middle element = " + middle.val);
    }

    private ListNode getMiddleElement(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
}
